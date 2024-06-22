package com.lily.ecommerce.order.repository

import com.lily.ecommerce.order.OrderLine
import com.lily.ecommerce.order.controller.OrderLineResponse
import org.springframework.data.jpa.repository.JpaRepository

interface OrderLineRepository: JpaRepository<OrderLine, Int>{
    fun findAllByOrderId(orderId: Int): List<OrderLine>
}
