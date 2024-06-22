package com.lily.ecommerce.order.dto

import com.lily.ecommerce.order.PaymentMethod

data class OrderResponseDTO(
    val id: Int,
    val reference: String?,
    val amount: Int?,
    val paymentMethod: PaymentMethod?,
    val customerId: String?,
)
