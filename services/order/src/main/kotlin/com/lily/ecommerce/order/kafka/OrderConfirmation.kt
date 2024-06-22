package com.lily.ecommerce.order.kafka

import com.lily.ecommerce.customer.CustomerResponse
import com.lily.ecommerce.order.PaymentMethod
import com.lily.ecommerce.product.PurchaseResponse

class OrderConfirmation(
    val orderReference: String?,
    val totalAmount: Int?,
    val paymentMethod: PaymentMethod?,
    val customer: CustomerResponse,
    val products: List<PurchaseResponse>?
)
