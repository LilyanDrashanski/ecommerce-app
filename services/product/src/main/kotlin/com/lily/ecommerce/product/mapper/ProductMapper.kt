package com.lily.ecommerce.product.mapper

import com.lily.ecommerce.category.CategoryService
import com.lily.ecommerce.product.Product
import com.lily.ecommerce.product.DTO.ProductRequestDTO
import com.lily.ecommerce.product.DTO.ProductResponseDTO
import org.springframework.stereotype.Service

@Service
class ProductMapper {

    fun toProduct(
        request: ProductRequestDTO,
        category: CategoryService
    ): Product {

        return Product(
            request.id,
            request.name,
            request.description,
            request.price,
            request.availableQuantity,
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


}
