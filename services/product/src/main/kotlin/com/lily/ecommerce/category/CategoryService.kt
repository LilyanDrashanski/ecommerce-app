package com.lily.ecommerce.category

import com.lily.ecommerce.exception.CategoryNotFoundException
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun getCategoryById(categoryId: Int?): Category {
        return categoryRepository.findById(categoryId!!)
            .orElseThrow { CategoryNotFoundException("Category not found with id: $categoryId.") }
    }
}
