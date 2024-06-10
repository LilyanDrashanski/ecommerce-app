package com.lily.ecommerce.customer

import com.lily.ecommerce.handler.CustomerNotFoundException
import lombok.RequiredArgsConstructor
import org.apache.commons.lang.StringUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
@RequiredArgsConstructor
class CustomerService(
    private val repository: CustomerRepository,
    private val mapper: CustomerMapper
) {

    fun createCustomer(request: CustomerRequest): String {
        val customer = repository.save(mapper.toCustomer(request))
        return customer.id
    }

    fun updateCustomer(request: CustomerRequest) {
        val customer = repository.findById(request.id)
            .orElseThrow { CustomerNotFoundException("Customer with id ${request.id} not found") }
        mergerCustomer(customer, request)
        repository.save(customer)
    }

    private fun mergerCustomer(customer: Customer, request: CustomerRequest) {
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

    fun findAllCustomers(): List<CustomerResponse>? {
        return repository.findAll()
            .stream()
            .map(mapper::fromCustomer)
            .collect(Collectors.toList())
    }

    fun findById(customerId: String): CustomerResponse {
        return repository.findById(customerId)
            .map(mapper::fromCustomer)
            .orElseThrow { CustomerNotFoundException("Customer with id $customerId not found") }
    }

    fun deleteCustomer(customerId: String) {
        repository.deleteById(customerId)
    }
}
