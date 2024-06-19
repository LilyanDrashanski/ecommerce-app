package com.lily.ecommerce.product


data class ProductResponse(
    var id: Int?,
    var name: String,
    var description: String,
    var price: Double,
    val availableQuantity: Double,
    val categoryId: Int,
    val categoryName: String,
    val categoryDescription: String,
)
