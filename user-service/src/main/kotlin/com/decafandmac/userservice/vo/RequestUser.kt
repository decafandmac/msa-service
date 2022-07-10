package com.decafandmac.userservice.vo

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class RequestUser(
    @Size(min = 4, message = "Email not be less than 4 characters")
    @Email
    var email: String,

    @Size(min = 2, message = "Name not be less than 2 characters")
    var name: String,

    @Size(min = 8, message = "Password not be less than 8 characters")
    var pwd: String
)
