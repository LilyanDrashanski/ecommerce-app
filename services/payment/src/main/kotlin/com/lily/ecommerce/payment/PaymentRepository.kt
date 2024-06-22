package com.lily.ecommerce.payment

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Int> {

}
