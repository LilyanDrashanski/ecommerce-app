package com.lily.ecommerce.customer


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Customer(
    @Id
    val id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: Address
)