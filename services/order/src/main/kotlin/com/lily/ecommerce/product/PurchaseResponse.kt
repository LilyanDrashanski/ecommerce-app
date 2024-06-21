package com.lily.ecommerce.product

data class PurchaseResponse(
    val productId: Int,
    val name: String,
    val price: Int,
    val quantity: Int
)