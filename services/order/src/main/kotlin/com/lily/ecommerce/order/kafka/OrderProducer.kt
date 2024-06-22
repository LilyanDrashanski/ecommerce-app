package com.lily.ecommerce.order.kafka

import org.apache.kafka.common.requests.DeleteAclsResponse.log
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class OrderProducer(
    val kafkaTemplate: KafkaTemplate<String, OrderConfirmation>
) {


    fun sendOrderConfirmation(orderConfirmation: OrderConfirmation) {
        log.info("Sending order confirmation")
        val message = MessageBuilder
            .withPayload(orderConfirmation)
            .setHeader(KafkaHeaders.TOPIC, "order-topic")
            .build()

        kafkaTemplate.send(message)
    }
}