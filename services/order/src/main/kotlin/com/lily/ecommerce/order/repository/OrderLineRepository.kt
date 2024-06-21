package com.lily.ecommerce.order.repository

import com.lily.ecommerce.order.OrderLine
import org.springframework.data.jpa.repository.JpaRepository

interface OrderLineRepository: JpaRepository<OrderLine, Int>{

}
