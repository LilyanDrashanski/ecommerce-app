package com.lily.ecommerce.customer

import lombok.*
import org.springframework.validation.annotation.Validated

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
class Address(
    private val street: String,
    private val zipCode: String,
    private val houseNumber: String
)
