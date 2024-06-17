package com.lily.ecommerce1.customer

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, String>
