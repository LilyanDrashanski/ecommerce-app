package com.lily.ecommerce.customer

import org.springframework.stereotype.Service

@Service
class CustomerMapper {
    fun toCustomer(request: CustomerRequest): Customer {
        return Customer.CustomerBuilder(
            id = request.id,
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            address = request.address
        ).build()
    }

    fun fromCustomer(customer: Customer): CustomerResponse {
        return CustomerResponse(
            customer.id,
            customer.firstName,
            customer.lastName,
            customer.email,
            customer.address
        )
    }
}
