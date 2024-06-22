package com.lily.ecommerce.payment

import com.lily.ecommerce.customer.CustomerResponse
import com.lily.ecommerce.order.PaymentMethod

data class PaymentRequestDTO(
    var amount: Int?,
    var paymentMethod: PaymentMethod?,
    var orderId: Int,
    var customer: CustomerResponse?,
    var orderReference: String?
)
