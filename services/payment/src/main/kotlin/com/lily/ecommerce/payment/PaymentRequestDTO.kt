package com.lily.ecommerce.payment

class PaymentRequestDTO(
    var id: Int?,
    var amount: Int?,
    var paymentMethod: PaymentMethod,
    var orderId: String?,
    var customer: Customer?,
    var orderReference: String?
)
