package com.lily.ecommerce.customer

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val service: CustomerService) {

    @PostMapping
    fun createCustomer(@RequestBody @Valid request: CustomerRequest): ResponseEntity<String> {
        return ResponseEntity.ok(service.createCustomer(request))
    }

    @PutMapping
    fun updateCustomer(@RequestBody @Valid request: CustomerRequest): ResponseEntity<Unit> {
        service.updateCustomer(request)
        return ResponseEntity.accepted().build()
    }

    @GetMapping
    fun findAllCustomers(): ResponseEntity<List<CustomerResponse>> {
        return ResponseEntity.ok(service.findAllCustomers())
    }

    @GetMapping("/{customer-id}")
    fun findCustomerById(@PathVariable("customer-id") customerId: String): ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(service.findById(customerId))
    }

    @DeleteMapping("/{customer-id}")
    fun deleteCustomer(@PathVariable("customer-id") customerId: String): ResponseEntity<Unit> {
        service.deleteCustomer(customerId)
        return ResponseEntity.accepted().build()
    }
}