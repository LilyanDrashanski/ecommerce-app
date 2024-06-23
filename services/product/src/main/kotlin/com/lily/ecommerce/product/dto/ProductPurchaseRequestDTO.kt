package com.lily.ecommerce.product.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class ProductPurchaseRequestDTO(
    @field:NotNull(message = "Product is mandatory")
    var productId: Int?,
    @field:Positive(message = "Quantity must be positive")
    var quantity: Int?,
)