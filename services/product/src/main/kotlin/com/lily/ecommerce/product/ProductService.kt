package com.lily.ecommerce.product

import CategoryService
import com.lily.ecommerce.exception.CategoryNotFoundException
import com.lily.ecommerce.exception.ProductPurchaseException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
abstract class ProductService(
    private val productRepository: ProductRepository,
    private val mapper: ProductMapper,
) {
    abstract val categoryService: CategoryService


    fun createProduct(request: ProductRequest): Product {
        val product = mapper.toProduct(request, categoryService)
        return productRepository.save(product)
    }

    fun purchaseProducts(request: List<ProductPurchaseRequest>): List<ProductPurchaseResponse>? {
        val productIds = request
            .stream()
            .map(ProductPurchaseRequest::id)
            .toList()
        val storedProducts = productRepository.findAllById(productIds)
        if (productIds.size != storedProducts.size) {
            throw ProductPurchaseException("One or more products does now exist")
        }
        val sortedRequest = request
            .stream()
            .sorted(Comparator.comparing(ProductPurchaseRequest::id))
            .toList()

        val purchasedProducts = mutableListOf<ProductPurchaseResponse>()

        for (i in storedProducts.indices) {
            val product = storedProducts[i]
            val productRequest = sortedRequest[i]
            if (product.available < productRequest.quantity) {
                throw ProductPurchaseException("Insufficient stock quantity for product with ID:: ${productRequest.id}")
            }
        }



        return purchasedProducts

    }


    fun findById(id: Int): ProductResponse {
        return productRepository.findById(id)
            .map(mapper::toProductResponse)
            .orElseThrow { CategoryNotFoundException("Product with $id not found") }
    }

    fun findAll(): List<ProductResponse> {
        return productRepository.findAll()
            .stream()
            .map(mapper::toProductResponse)
            .collect(Collectors.toList())

    }
}