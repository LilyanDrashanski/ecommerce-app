package com.lily.ecommerce.kafka.payment

class PaymentConfirmation(
    val orderReference: String,
    val amount: Int,
    val paymentMethod: PaymentMethod,
    val customerFirstName: String,
    val customerLastName: String,
    val customerEmail: String,
)