package com.lily.ecommerce

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
class OrderApplication

fun main(args: Array<String>) {
	runApplication<OrderApplication>(*args)
}
