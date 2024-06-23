package com.lily.ecommerce.product.mapper

import com.lily.ecommerce.category.CategoryService
import com.lily.ecommerce.product.Product
import com.lily.ecommerce.product.dto.ProductPurchaseResponseDTO
import com.lily.ecommerce.product.dto.ProductRequestDTO
import com.lily.ecommerce.product.dto.ProductResponseDTO
import org.springframework.stereotype.Service


@Service
class ProductMapper {

    fun toProduct(
        request: ProductRequestDTO,
        category: CategoryService
    ): Product {

        return Product(
            id = null,
            name = request.name,
            description = request.description,
            price = request.price,
            availableQuantity = request.availableQuantity,
            category = category.getCategoryById(request.categoryId)
        )
    }

    fun toProductResponse(product: Product): ProductResponseDTO {
        return ProductResponseDTO(
            product.id,
            product.name,
            product.description,
            product.price,
            product.availableQuantity,
            product.category.id,
            product.category.name,
            product.category.description
        )
    }

    fun toProductPurchaseResponse(product: Product, quantity: Int): ProductPurchaseResponseDTO {
        return ProductPurchaseResponseDTO(
            product.id,
            product.name,
            product.description,
            product.price,
            quantity
        )
    }


}
