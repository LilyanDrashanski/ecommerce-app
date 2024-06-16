package com.lily.ecommerce.product

data class ProductPurchaseResponse(
    val productId: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: Int,
    val quantity: Int
)
