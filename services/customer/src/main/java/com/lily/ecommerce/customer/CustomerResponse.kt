package com.lily.ecommerce.customer

import jakarta.validation.constraints.Email
import org.jetbrains.annotations.NotNull

data class CustomerResponse(
    var id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: Address
)
