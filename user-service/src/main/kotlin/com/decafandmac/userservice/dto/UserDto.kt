package com.decafandmac.userservice.dto

import com.decafandmac.userservice.vo.ResponseOrder
import java.util.Date
import java.util.UUID

data class UserDto(
    var email: String = "",
    var name: String = "",
    var pwd: String = "",
    var userId: String = "",
    var createdAt: Date = Date(),
    var encryptedPwd: String = "",

    var orders: MutableList<ResponseOrder> = mutableListOf()
)