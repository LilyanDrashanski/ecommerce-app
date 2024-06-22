package com.lily.ecommerce.payment

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/api/v1/payments")
class PaymentController (
    private val service: PaymentService
) {
    @PostMapping
    fun createPayment(@RequestBody @Valid payment: PaymentRequestDTO): ResponseEntity<Payment> {
        return ResponseEntity.ok(service.createPayment(payment))
    }
}