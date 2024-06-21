package com.lily.ecommerce.order.controller

import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.service.OrderService
import com.lily.ecommerce.order.dto.OrderRequest
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    val service: OrderService
) {

        @PostMapping
        fun createOrder(@RequestBody @Valid request: OrderRequest): ResponseEntity<Order> {
            return ResponseEntity.ok(service.createdOrder(request))
        }
}