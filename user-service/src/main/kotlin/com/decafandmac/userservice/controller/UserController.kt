package com.decafandmac.userservice.controller

import com.decafandmac.userservice.vo.Greeting
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(
    private val env: Environment,
    private val greeting: Greeting
)  {

    @GetMapping("/health_check")
    fun status() = "It's Working in User service"

    @GetMapping("/welcome")
//    fun welcome() = env.getProperty("greeting.message")
    fun welcome() = greeting.message
}