package com.lily.ecommerce.product

import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal

data class ProductPurchaseRequest(
    @NotNull("Product is mandatory")
    var id: Int,
    @Positive(message = "Quantity id is mandatory")
    var quantity: Int,
)