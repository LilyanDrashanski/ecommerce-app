package com.lily.ecommerce.product

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val service: ProductService
) {
    @PostMapping
    fun createProduct(@Valid @RequestBody request: ProductRequest): ResponseEntity<Product> {
        return ResponseEntity.ok(service.createProduct(request))
    }

    @PostMapping("/purchase")
    fun purchaseProduct(@Valid @RequestBody request: List<ProductPurchaseRequest>): ResponseEntity<List<ProductPurchaseResponse>> {
        return ResponseEntity.ok(service.purchaseProducts(request))
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") id: Int): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(service.findById(id))
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(service.findAll())
    }

}