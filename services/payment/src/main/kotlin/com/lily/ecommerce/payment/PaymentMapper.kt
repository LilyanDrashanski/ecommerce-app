package com.lily.ecommerce.payment

import org.springframework.stereotype.Service

@Service
class PaymentMapper {
    fun toPayment(payment: PaymentRequestDTO): Payment {
        return Payment(
            paymentMethod = payment.paymentMethod,
            id = payment.id,
            orderId = payment.orderId,
            amount = payment.amount,
            orderReference = payment.orderReference

        )
    }

}
