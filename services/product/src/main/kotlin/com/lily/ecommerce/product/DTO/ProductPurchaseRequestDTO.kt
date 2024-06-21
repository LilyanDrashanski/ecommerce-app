package com.lily.ecommerce.product.DTO

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProductPurchaseRequestDTO(
    @field:NotBlank(message = "Product is mandatory")
    var id: Int?,
    @field:Positive(message = "Quantity id is mandatory")
    var quantity: Int?,
)