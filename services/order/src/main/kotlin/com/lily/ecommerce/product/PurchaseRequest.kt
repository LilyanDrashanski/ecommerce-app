package com.lily.ecommerce.product

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class PurchaseRequest(
    @field:NotBlank(message = "Product id should not be null")
    val productId: Int?,
    @field:NotNull
    val quantity: Int?
)
