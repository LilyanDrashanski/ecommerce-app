package com.lily.ecommerce.customer

import com.lily.ecommerce.customer.DTO.CustomerRequestDTO
import com.lily.ecommerce.customer.DTO.CustomerResponseDTO
import com.lily.ecommerce.customer.mapper.CustomerMapper
import com.lily.ecommerce.exception.CustomerNotFoundException
import org.apache.commons.lang.StringUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class CustomerService(
    private val repository: CustomerRepository,
    private val mapper: CustomerMapper
) {

    fun createCustomer(request: CustomerRequestDTO): Customer {
        val customer = repository.save(mapper.toCustomer(request))
        return customer
    }

    fun updateCustomer(request: CustomerRequestDTO, customerId: String) {
        val customer = repository.findById(customerId)
            .orElseThrow { CustomerNotFoundException("Customer with id $customerId not found") }
        mergerCustomer(customer, request)
        repository.save(customer)
    }

    private fun mergerCustomer(customer: Customer, request: CustomerRequestDTO) {
        if (StringUtils.isNotBlank(request.firstName)) {
            customer.firstName = request.firstName
        }
        if (StringUtils.isNotBlank(request.lastName)) {
            customer.lastName = request.lastName
        }
        if (StringUtils.isNotBlank(request.email)) {
            customer.email = request.email
        }
        if (request.address != null) {
            customer.address = request.address
        }
    }

    fun findAllCustomers(): List<CustomerResponseDTO>? {
        return repository.findAll()
            .stream()
            .map(mapper::fromCustomer)
            .collect(Collectors.toList())
    }

    fun findById(customerId: String): CustomerResponseDTO {
        return repository.findById(customerId)
            .map(mapper::fromCustomer)
            .orElseThrow { CustomerNotFoundException("Customer with id $customerId not found") }
    }

    fun deleteCustomer(customerId: String) {
        repository.deleteById(customerId)
    }
}
