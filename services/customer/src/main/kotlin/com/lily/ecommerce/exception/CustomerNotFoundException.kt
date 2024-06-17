package com.lily.ecommerce1.exception


data class CustomerNotFoundException(val msg: String): RuntimeException()