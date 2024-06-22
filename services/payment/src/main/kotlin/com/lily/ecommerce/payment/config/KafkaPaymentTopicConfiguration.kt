package com.lily.ecommerce.payment.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaPaymentTopicConfiguration {

    @Bean
    fun paymentTopic(): NewTopic{
        return TopicBuilder.name("payment-topic").build()
    }
}