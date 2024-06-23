package com.lily.ecommerce.payment

import com.lily.ecommerce.payment.notification.NotificationProducer
import com.lily.ecommerce.payment.notification.PaymentNotificationRequestDTO
import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val repository: PaymentRepository,
    private val mapper: PaymentMapper,
    private val notificationProducer: NotificationProducer
) {

    fun createPayment(request: PaymentRequestDTO): Payment {
        val payment = repository.save(mapper.toPayment(request))

        notificationProducer.sendNotification(
            PaymentNotificationRequestDTO(
                orderReference = request.orderReference,
                amount = request.amount,
                customerEmail = request.customer?.email,
                customerFirstName = request.customer?.firstName,
                customerLastName = request.customer?.lastName,
                paymentMethod = request.paymentMethod
            )
        )
        return payment
    }
}
