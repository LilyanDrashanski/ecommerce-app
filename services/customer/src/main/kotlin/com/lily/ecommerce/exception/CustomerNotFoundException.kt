package com.lily.ecommerce.exception


data class CustomerNotFoundException(val msg: String): RuntimeException()