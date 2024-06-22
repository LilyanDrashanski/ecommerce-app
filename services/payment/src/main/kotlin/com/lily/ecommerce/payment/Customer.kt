package com.lily.ecommerce.payment

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import org.springframework.validation.annotation.Validated

@Validated
data class Customer(
    var id: String?,
    @field:NotEmpty(message = "Firstname is required")
    var firstName: String?,
    @field:NotEmpty(message = "Lastname is required")
    var lastName: String?,
    @field:NotEmpty(message = "Email is required")
    @field:Email(message = "Email is not valid ")
    var email: String?
)
