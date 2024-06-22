package com.lily.ecommerce.notification

import com.lily.ecommerce.kafka.order.OrderConfirmation
import com.lily.ecommerce.kafka.payment.PaymentConfirmation
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.*

@Document
class Notification(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val type: NotificationType,
    val notificationDate: LocalDateTime,
    val orderConfirmation: OrderConfirmation?,
    val paymentConfirmation: PaymentConfirmation?
)