package com.lily.ecommerce.product

import com.lily.ecommerce.category.CategoryService
import com.lily.ecommerce.exception.CategoryNotFoundException
import com.lily.ecommerce.exception.ProductPurchaseException
import com.lily.ecommerce.product.dto.ProductPurchaseRequestDTO
import com.lily.ecommerce.product.dto.ProductPurchaseResponseDTO
import com.lily.ecommerce.product.dto.ProductRequestDTO
import com.lily.ecommerce.product.dto.ProductResponseDTO
import com.lily.ecommerce.product.mapper.ProductMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val mapper: ProductMapper,
    val categoryService: CategoryService
) {
    fun createProduct(request: ProductRequestDTO): Product {
        val product = mapper.toProduct(request, categoryService)
        return productRepository.save(product)
    }

    fun purchaseProducts(request: List<ProductPurchaseRequestDTO>): List<ProductPurchaseResponseDTO>? {

        val productIds = request.map { it.productId }
        println("Product IDs from request: $productIds")


        val storedProducts = productRepository.findAllById(productIds)
        println("Stored products: $storedProducts")

        if (productIds.size != storedProducts.size) {
            throw ProductPurchaseException("One or more products does now exist")
        }

        val sortedRequest = request.sortedBy { it.productId }
        println("Sorted request: $sortedRequest")

        val purchasedProducts = mutableListOf<ProductPurchaseResponseDTO>()

        for ((i, product) in storedProducts.withIndex()) {
            val productRequest = sortedRequest[i]
            if (product.availableQuantity!! < productRequest.quantity!!) {
                throw ProductPurchaseException("Insufficient stock quantity for product with ID: ${productRequest.productId}")
            }


            val newAvailableQuantity = product.availableQuantity!! - productRequest.quantity!!
            product.availableQuantity = newAvailableQuantity
            productRepository.save(product)
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity!!))
        }

        println("Purchased products: $purchasedProducts")
        return purchasedProducts

    }

    fun findById(id: Int): ProductResponseDTO {
        return productRepository.findById(id).map(mapper::toProductResponse)
            .orElseThrow { CategoryNotFoundException("Product with $id not found") }
    }

    fun findAll(): List<ProductResponseDTO> {
        return productRepository.findAll().stream().map(mapper::toProductResponse).collect(Collectors.toList())

    }
}