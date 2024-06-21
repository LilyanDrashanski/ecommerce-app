package com.lily.ecommerce.exception


data class BusinessException(val msg: String): RuntimeException()
