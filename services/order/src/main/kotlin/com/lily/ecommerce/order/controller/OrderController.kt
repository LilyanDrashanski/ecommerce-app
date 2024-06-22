package com.lily.ecommerce.order.controller

import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.service.OrderService
import com.lily.ecommerce.order.dto.OrderRequestDTO
import com.lily.ecommerce.order.dto.OrderResponseDTO
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    val service: OrderService
) {

    @PostMapping
    fun createOrder(@RequestBody @Valid request: OrderRequestDTO): ResponseEntity<Order> {
        return ResponseEntity.ok(service.createdOrder(request))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<OrderResponseDTO>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: Int): ResponseEntity<OrderResponseDTO> {
        return ResponseEntity.ok(service.findById(id))
    }
}