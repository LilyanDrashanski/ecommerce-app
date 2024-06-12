package com.lily.ecommerce.category

import jakarta.persistence.*
import product.Product
import java.math.BigDecimal

@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var description: String,
    var price: BigDecimal,
    @OneToMany(mappedBy = "category")
    var products: List<Product>
)