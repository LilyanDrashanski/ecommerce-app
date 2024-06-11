package com.lily.ecommerce.customer


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class Customer(
    @Id
    val id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: Address
) {

    class CustomerBuilder {
        private var id: String = ""
        private var firstName: String = ""
        private var lastName: String = ""
        private var email: String = ""
        private var address: Address? = null

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String) = apply { this.firstName = firstName }
        fun lastName(lastName: String) = apply { this.lastName = lastName }
        fun email(email: String) = apply { this.email = email }
        fun address(address: Address) = apply { this.address = address }

        fun build(): Customer {
            val validAddress = address ?: throw IllegalArgumentException("Address must be provided")
            return Customer(id, firstName, lastName, email, validAddress)
        }
    }
}