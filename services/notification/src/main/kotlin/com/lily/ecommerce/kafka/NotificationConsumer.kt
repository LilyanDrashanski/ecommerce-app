package com.lily.ecommerce.kafka

import com.lily.ecommerce.notification.Notification
import com.lily.ecommerce.notification.NotificationRepository
import com.lily.ecommerce.notification.NotificationType.*
import com.lily.ecommerce.email.EmailService
import com.lily.ecommerce.kafka.order.OrderConfirmation
import com.lily.ecommerce.kafka.payment.PaymentConfirmation
import org.apache.kafka.common.requests.DeleteAclsResponse.log
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class NotificationConsumer(
    private val repository: NotificationRepository, private val emailService: EmailService
) {

    @KafkaListener(topics = ["payment-topic"])
    fun consumePaymentSuccessNotification(paymentConfirmation: PaymentConfirmation) {
        log.info(String.format("Consuming the payment from payment-topic Topic:: %s", paymentConfirmation))
        repository.save(
            Notification(
                type = PAYMENT_CONFIRMATION,
                notificationDate = LocalDateTime.now(),
                paymentConfirmation = paymentConfirmation,
                orderConfirmation = null
            )
        )
        val customerName = paymentConfirmation.customerFirstName + " " + paymentConfirmation.customerLastName
        emailService.sendPaymentSuccessEmail(
            customerName = customerName,
            amount = paymentConfirmation.amount,
            destinationEmail = paymentConfirmation.customerEmail,
            orderReference = paymentConfirmation.orderReference
        )
    }

    @KafkaListener(topics = ["order-topic"])
    fun consumeOrderConfirmationNotification(orderConfirmation: OrderConfirmation) {
        log.info(String.format("Consuming the payment from order-topic Topic:: %s", orderConfirmation))
        repository.save(
            Notification(
                type = ORDER_CONFIRMATION,
                notificationDate = LocalDateTime.now(),
                orderConfirmation = orderConfirmation,
                paymentConfirmation = null
            )
        )
        val customerName = orderConfirmation.customer.firstName + " " + orderConfirmation.customer.lastName
        emailService.sentOrderConfirmationEmail(
            customerName = customerName,
            amount = orderConfirmation.totalAmount,
            destinationEmail = orderConfirmation.customer.email,
            orderReference = orderConfirmation.orderReference,
            products = orderConfirmation.products
        )
    }
}