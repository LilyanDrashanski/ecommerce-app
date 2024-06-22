package com.lily.ecommerce.payment

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "payment-client",
    url = "\${application.config.payment-url}",)
interface PaymentClient {

    @PostMapping
    fun requestOrderPayment(@RequestBody request: PaymentRequestDTO)
}