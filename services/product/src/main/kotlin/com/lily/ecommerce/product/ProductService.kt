package com.lily.ecommerce.product

import com.lily.ecommerce.category.CategoryService
import com.lily.ecommerce.exception.CategoryNotFoundException
import com.lily.ecommerce.exception.ProductPurchaseException
import com.lily.ecommerce.product.DTO.ProductPurchaseRequestDTO
import com.lily.ecommerce.product.DTO.ProductPurchaseResponseDTO
import com.lily.ecommerce.product.DTO.ProductRequestDTO
import com.lily.ecommerce.product.DTO.ProductResponseDTO
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
        val productIds = request
            .stream()
            .map(ProductPurchaseRequestDTO::id)
            .toList()
        val storedProducts = productRepository.findAllById(productIds)
        if (productIds.size != storedProducts.size) {
            throw ProductPurchaseException("One or more products does now exist")
        }
        val sortedRequest = request
            .stream()
            .sorted(Comparator.comparing(ProductPurchaseRequestDTO::id))
            .toList()

        val purchasedProducts = mutableListOf<ProductPurchaseResponseDTO>()

        for (i in storedProducts.indices) {
            val product = storedProducts[i]
            val productRequest = sortedRequest[i]
            if (product.availableQuantity < productRequest.quantity) {
                throw ProductPurchaseException("Insufficient stock quantity for product with ID:: ${productRequest.id}")
            }
        }

        return purchasedProducts

    }

    fun findById(id: Int): ProductResponseDTO {
        return productRepository.findById(id)
            .map(mapper::toProductResponse)
            .orElseThrow { CategoryNotFoundException("Product with $id not found") }
    }

    fun findAll(): List<ProductResponseDTO> {
        return productRepository.findAll()
            .stream()
            .map(mapper::toProductResponse)
            .collect(Collectors.toList())

    }
}