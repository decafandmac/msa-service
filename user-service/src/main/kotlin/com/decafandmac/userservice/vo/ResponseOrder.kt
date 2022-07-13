package com.decafandmac.userservice.vo

import java.util.Date

data class ResponseOrder(
    var productId: String,
    var qty: Int,
    var unitPrice: Int,
    var totalPrice: Int,
    var createdAt: Date,
    var orderId: String
)
