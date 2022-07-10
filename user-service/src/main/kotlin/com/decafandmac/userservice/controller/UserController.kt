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
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(
    private val env: Environment,
    private val greeting: Greeting,
    private val userService: UserService
)  {

    @GetMapping("/health_check")
    fun status() = "It's Working in User service"

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
}