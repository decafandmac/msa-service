package com.decafandmac.userservice.service

import com.decafandmac.userservice.dto.UserDto

interface UserService {
    fun createUser(userDto: UserDto): UserDto
}