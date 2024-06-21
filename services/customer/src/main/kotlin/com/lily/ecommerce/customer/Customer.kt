package com.lily.ecommerce.customer


import com.lily.ecommerce.customer.address.Address
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Document
data class Customer(

    @Id
    var token: String = UUID.randomUUID().toString(),
    var firstName: String?,
    var lastName: String?,
    var email: String?,
    var address: Address?
)