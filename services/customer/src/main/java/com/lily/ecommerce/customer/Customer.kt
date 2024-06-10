package com.lily.ecommerce.customer

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
class Customer private constructor(
    @Id
    val id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: Address
) {

    class CustomerBuilder(
        private val id: String,
        private var firstName: String,
        private var lastName: String,
        private var email: String,
        private var address: Address
    ) {
        fun build() = Customer(id, firstName, lastName, email, address)

    }
}