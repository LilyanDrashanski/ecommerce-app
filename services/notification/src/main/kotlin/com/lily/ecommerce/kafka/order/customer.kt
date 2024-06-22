package com.lily.ecommerce.kafka.order

data class customer(
    var id: String,
    var firstName: String,
    var lastName: String,
    var email: String?
)
