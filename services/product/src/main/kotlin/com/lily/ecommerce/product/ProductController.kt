package com.lily.ecommerce.product

import com.lily.ecommerce.product.dto.ProductPurchaseRequestDTO
import com.lily.ecommerce.product.dto.ProductPurchaseResponseDTO
import com.lily.ecommerce.product.dto.ProductRequestDTO
import com.lily.ecommerce.product.dto.ProductResponseDTO
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
     private val service: ProductService
) {
    @PostMapping
    fun createProduct(@Valid @RequestBody request: ProductRequestDTO): ResponseEntity<Product> {
        return ResponseEntity.ok(service.createProduct(request))
    }

    @PostMapping("/purchase")
    fun purchaseProduct(@Valid @RequestBody request: List<ProductPurchaseRequestDTO>): ResponseEntity<List<ProductPurchaseResponseDTO>> {
        println("Received purchase request: $request")

        return ResponseEntity.ok(service.purchaseProducts(request))
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable("id") id: Int): ResponseEntity<ProductResponseDTO> {
        return ResponseEntity.ok(service.findById(id))
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<ProductResponseDTO>> {
        return ResponseEntity.ok(service.findAll())
    }

}