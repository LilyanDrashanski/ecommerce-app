package com.lily.ecommerce.product.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProductRequestDTO(
    @field:NotBlank(message = "Product name is required")
    var name: String?,
    @field:NotBlank(message = "Product description is required")
    var description: String?,
    @field:Positive(message = "Price should be positive")
    var price: Int?,
    @field:Positive(message = "Quantity should be positive")
    val availableQuantity: Int?,
    @field:NotBlank(message = "Category Id is required")
    var categoryId: Int?
)
