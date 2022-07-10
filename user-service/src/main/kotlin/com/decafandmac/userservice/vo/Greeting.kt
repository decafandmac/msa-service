package com.decafandmac.userservice.vo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class Greeting(
    // application properties 의 값을 가져오는 annotation
    @Value("\${greeting.message}") val message: String
)
