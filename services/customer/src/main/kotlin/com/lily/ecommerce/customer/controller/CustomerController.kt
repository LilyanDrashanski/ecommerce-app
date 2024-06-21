package com.lily.ecommerce.customer.controller

import com.lily.ecommerce.customer.Customer
import com.lily.ecommerce.customer.DTO.CustomerRequestDTO
import com.lily.ecommerce.customer.DTO.CustomerResponseDTO
import com.lily.ecommerce.customer.CustomerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(private val service: CustomerService) {

    @PostMapping
    fun createCustomer(@RequestBody @Valid request: CustomerRequestDTO): ResponseEntity<Customer> {
        return ResponseEntity.ok(service.createCustomer(request))
    }

    @PutMapping("/{customer-id}")
    fun updateCustomer(@RequestBody @Valid request: CustomerRequestDTO, @PathVariable("customer-id") customerId: String): ResponseEntity<Unit> {
        service.updateCustomer(request, customerId)
        return ResponseEntity.accepted().build()
    }

    @GetMapping
    fun findAllCustomers(): ResponseEntity<List<CustomerResponseDTO>> {
        return ResponseEntity.ok(service.findAllCustomers())
    }

    @GetMapping("/{customer-id}")
    fun findCustomerById(@PathVariable("customer-id") customerId: String): ResponseEntity<CustomerResponseDTO> {
        return ResponseEntity.ok(service.findById(customerId))
    }

    @DeleteMapping("/{customer-id}")
    fun deleteCustomer(@PathVariable("customer-id") customerId: String): ResponseEntity<Unit> {
        service.deleteCustomer(customerId)
        return ResponseEntity.accepted().build()
    }
}