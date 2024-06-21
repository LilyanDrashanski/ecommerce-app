package com.lily.ecommerce.product.DTO

data class ProductPurchaseResponseDTO(
    val productId: Int,
    val productName: String,
    val productDescription: String,
    val productPrice: Int,
    val quantity: Int
)
