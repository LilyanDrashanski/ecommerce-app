package com.lily.ecommerce.product

import com.lily.ecommerce.category.CategoryService
import org.springframework.stereotype.Service

@Service
class ProductMapper {

    fun toProduct(
        request: ProductRequest,
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

    fun toProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            product.id,
            product.name,
            product.description,
            product.price,
            product.available,
            product.category.id,
            product.category.name,
            product.category.description
        )
    }


}
