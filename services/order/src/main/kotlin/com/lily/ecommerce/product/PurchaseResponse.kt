package com.lily.ecommerce.product

data class PurchaseResponse(
    val productId: Int,
    val productName: String,
    val productPrice: Int,
    val quantity: Int
)