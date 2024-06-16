package com.lily.ecommerce.product

import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class ProductRequest(
    var id: Int,
    @NotNull("Product name is required")
    var name: String,
    @NotNull("Product description is required")
    var description: String,
    @Positive(message = "Price should be positive")
    var price: Double,
    @Positive(message = "Quantity should be positive")
    val availableQuantity: Double,
    @NotNull("Category Id is required")
    var categoryId: Int
)
