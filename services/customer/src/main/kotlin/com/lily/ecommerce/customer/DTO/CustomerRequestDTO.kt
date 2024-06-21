package com.lily.ecommerce.customer.DTO

import com.lily.ecommerce.customer.address.Address
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import java.util.*


 data class CustomerRequestDTO(
    @field:NotBlank(message = "First name must not be null")
    var firstName: String?,
    @field:NotBlank(message = "Last name must not be null")
    var lastName: String?,
    @field:NotBlank(message = "Email must not be null")
    @field:Email(message = "Customer email is not valid")
    var email: String?,
    var address: Address?
)
