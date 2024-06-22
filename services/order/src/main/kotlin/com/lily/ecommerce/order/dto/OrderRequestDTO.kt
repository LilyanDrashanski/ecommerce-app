package com.lily.ecommerce.order.dto

import com.lily.ecommerce.order.PaymentMethod
import com.lily.ecommerce.product.PurchaseRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class OrderRequestDTO(
    var id: Int,
    var reference: String?,
    @field:Positive(message = "Amount must be positive")
    var amount: Int?,
    @field:NotNull("Payment method should not be null")
    var paymentMethod: PaymentMethod?,
    @field:NotBlank(message = "Customer id method should not be null")
    var customerId: String?,
    @field:NotNull("Product should should not be null")
    var products: List<PurchaseRequest>?
)
