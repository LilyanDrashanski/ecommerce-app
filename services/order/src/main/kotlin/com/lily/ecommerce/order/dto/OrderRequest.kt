package com.lily.ecommerce.order.dto

import com.lily.ecommerce.order.PaymentMethod
import com.lily.ecommerce.product.PurchaseRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive

data class OrderRequest(
    val id: Int,
    val reference: String?,
    @field:Positive
    val amount: Int?,
    @field:NotBlank(message = "Payment method should not be null")
    val paymentMethod: PaymentMethod?,
    @field:NotBlank(message = "Customer id method should not be null")
    @field:NotEmpty(message = "Customer id method should not be null")
    val customerId: String?,
    @field:NotBlank(message = "Product should should not be null")
    val products: List<PurchaseRequest>?
)
