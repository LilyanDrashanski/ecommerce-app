package com.lily.ecommerce.order.controller

import com.lily.ecommerce.order.service.OrderLineService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order-lines")
class OrderLineController(
    private val orderLineService: OrderLineService

) {

    @GetMapping("/order/{order-id}")
    fun findByOrderId(@PathVariable("order-id") orderId: Int): ResponseEntity<List<OrderLineResponse>> {
        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderId))
    }

}