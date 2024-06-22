package com.lily.ecommerce.kafka.order

data class Products(
    val productId: Int,
    val name: String,
    val description: String,
    val price: Int,
    val quantity: Int
)
