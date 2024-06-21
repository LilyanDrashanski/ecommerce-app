package com.lily.ecommerce.order.dto

data class OrderLineRequest(
    val id: Int?,
    val orderId: Int,
    val productId: Int,
    val quantity: Int



)
