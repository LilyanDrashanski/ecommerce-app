package com.lily.ecommerce.exception


data class CategoryNotFoundException(val msg: String): RuntimeException()