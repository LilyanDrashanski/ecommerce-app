package com.lily.ecommerce.handler

import lombok.Data
import lombok.EqualsAndHashCode

@EqualsAndHashCode(callSuper = true)
@Data
class CustomerNotFoundException(msg: String): RuntimeException()