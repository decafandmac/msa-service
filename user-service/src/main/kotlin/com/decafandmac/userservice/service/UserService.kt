package com.decafandmac.userservice.service

import com.decafandmac.userservice.dto.UserDto
import com.decafandmac.userservice.entity.UserEntity

interface UserService {
    fun createUser(userDto: UserDto): UserDto
    fun getUserByUserId(userId: String): UserDto
    fun getUserByAll(): Iterable<UserEntity>
}