package com.lily.ecommerce.product

import com.lily.ecommerce.category.Category
import jakarta.persistence.*

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String?,
    val name: String?,
    val description: String?,
    val price: Double?,
    val availableQuantity: Double?,
    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category
)