package com.lily.ecommerce.product

import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class PurchaseRequest(
    @NotNull("Product id should not be null")
    val productId: Int,
    @Positive
    val quantity: Int
) {

}
