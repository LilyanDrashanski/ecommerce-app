package com.lily.ecommerce.customer.mapper

import com.lily.ecommerce.customer.Customer
import com.lily.ecommerce.customer.DTO.CustomerRequestDTO
import com.lily.ecommerce.customer.DTO.CustomerResponseDTO
import org.springframework.stereotype.Service

@Service
class CustomerMapper {
    fun toCustomer(request: CustomerRequestDTO): Customer {
        return Customer(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            address = request.address,
        )
    }

    fun fromCustomer(customer: Customer): CustomerResponseDTO {
        return CustomerResponseDTO(
            token = customer.token,
            customer.firstName,
            customer.lastName,
            customer.email,
            customer.address
        )
    }
}
