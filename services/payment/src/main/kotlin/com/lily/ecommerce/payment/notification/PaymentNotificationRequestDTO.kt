package com.lily.ecommerce.payment.notification

import com.lily.ecommerce.payment.PaymentMethod

data class PaymentNotificationRequestDTO(
    val orderReference: String?,
    val amount: Int?,
    val paymentMethod: PaymentMethod,
    val customerFirstName: String?,
    val customerLastName: String?,
    val customerEmail: String?,
)
