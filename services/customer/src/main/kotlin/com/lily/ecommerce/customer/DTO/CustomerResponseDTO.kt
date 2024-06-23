package com.lily.ecommerce.customer.DTO

import com.lily.ecommerce.customer.address.Address

data class CustomerResponseDTO(
    var id: String,
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var address: Address?
)
