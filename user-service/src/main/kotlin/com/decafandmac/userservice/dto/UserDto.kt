package com.decafandmac.userservice.dto

import java.util.Date
import java.util.UUID

data class UserDto(
    var email: String = "",
    var name: String = "",
    var pwd: String = "",
    var userId: String = UUID.randomUUID().toString(),
    var createdAt: Date = Date(),
    var encryptedPwd: String = ""
)