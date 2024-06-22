package com.lily.ecommerce.order

import jakarta.persistence.*

@Entity
data class OrderLine(
    @Id @GeneratedValue
    val id: Int?,
    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: Order,
    val productId: Int?,
    val quantity: Int?,
)
