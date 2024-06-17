package com.lily.ecommerce1.customer

data class CustomerResponse(
    var id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: Address
)
