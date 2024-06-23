package com.lily.ecommerce.product.dto


data class ProductResponseDTO(
    var id: Int?,
    var name: String?,
    var description: String?,
    var price: Int?,
    val availableQuantity: Int?,
    val categoryId: Int,
    val categoryName: String,
    val categoryDescription: String,
)
