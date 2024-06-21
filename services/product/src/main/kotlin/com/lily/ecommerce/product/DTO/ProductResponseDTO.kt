package com.lily.ecommerce.product.DTO


data class ProductResponseDTO(
    var id: Int,
    var name: String,
    var description: String,
    var price: Double,
    val availableQuantity: Double,
    val categoryId: Int,
    val categoryName: String,
    val categoryDescription: String,
)
