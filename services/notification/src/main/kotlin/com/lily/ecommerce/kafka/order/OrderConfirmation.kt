package com.lily.ecommerce.kafka.order

import com.lily.ecommerce.kafka.payment.PaymentMethod

data class OrderConfirmation(
    val orderReference: String,
    val totalAmount: Int,
    val paymentMethod: PaymentMethod,
    val customer: customer,
    val products: List<Products>
)