package com.lily.ecommerce.category

import jakarta.persistence.*
import com.lily.ecommerce.product.Product

@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var description: String,
    @OneToMany(mappedBy = "category")
    var products: List<Product>
)