package com.decafandmac.userservice.controller

import com.decafandmac.userservice.dto.UserDto
import com.decafandmac.userservice.entity.UserEntity
import com.decafandmac.userservice.service.UserService
import com.decafandmac.userservice.vo.Greeting
import com.decafandmac.userservice.vo.RequestUser
import com.decafandmac.userservice.vo.ResponseUser
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user-service/")
class UserController(
    private val env: Environment,
    private val greeting: Greeting,
    private val userService: UserService
)  {

    @GetMapping("/health_check")
    fun status() = "It's Working in User service on PORT ${env.getProperty("local.server.port")}"

    @GetMapping("/welcome")
//    fun welcome() = env.getProperty("greeting.message")
    fun welcome() = greeting.message

    @PostMapping("/users")
    fun createUser(@RequestBody user: RequestUser): ResponseEntity<ResponseUser> {
        val modelMapper: ModelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userDto: UserDto = modelMapper.map(user, UserDto::class.java)
        userService.createUser(userDto);

        val responseUser: ResponseUser = modelMapper.map(userDto, ResponseUser::class.java)

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser)
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<ResponseUser>> {
        var userList: Iterable<UserEntity> = userService.getUserByAll()
        var result: MutableList<ResponseUser> = mutableListOf<ResponseUser>()

        userList.forEach {
            result.add(ModelMapper().map(it, ResponseUser::class.java))
        }

        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable("userId") userId: String): ResponseEntity<ResponseUser> {
        var userDto: UserDto = userService.getUserByUserId(userId)
        val result: ResponseUser = ModelMapper().map(userDto, ResponseUser::class.java)

        return ResponseEntity.status(HttpStatus.OK).body(result)
    }
}