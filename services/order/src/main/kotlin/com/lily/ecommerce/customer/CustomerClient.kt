package com.lily.ecommerce.customer

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@FeignClient(
    name =  "customer-service",
    url = "\${application.config.customer-url}",
    )
interface CustomerClient {
    @GetMapping("/customer-id")
    fun findCustomerById(@PathVariable ("custoemr-id") customerId: String): Optional<CustomerResponse>

}