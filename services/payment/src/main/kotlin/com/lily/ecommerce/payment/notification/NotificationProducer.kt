package com.lily.ecommerce.payment.notification

import org.apache.kafka.common.requests.DeleteAclsResponse.log
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class NotificationProducer(
    private val kafkaTemplate: KafkaTemplate<String, PaymentNotificationRequestDTO>
) {

    fun sendNotification(request: PaymentNotificationRequestDTO) {
        log.info("Sending notification with body <{}>", request)

        val message = MessageBuilder.withPayload(request).setHeader(KafkaHeaders.TOPIC, "payment-topic").build()
        kafkaTemplate.send(message)
    }
}