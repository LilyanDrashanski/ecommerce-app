package com.lily.ecommerce1.customer

import jakarta.validation.constraints.Email
import org.jetbrains.annotations.NotNull
import java.util.*


data class CustomerRequest(
    var id: String = UUID.randomUUID().toString(),
    @NotNull("Customer first name is required")
    var firstName: String,
    @NotNull("Customer last name is required")
    var lastName: String,
    @NotNull("Customer email is required")
    @Email(message = "Customer email is not valid")
    var email: String,
    var address: Address
)
