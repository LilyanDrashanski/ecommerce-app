package com.lily.ecommerce.order.repository

import com.lily.ecommerce.order.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository :JpaRepository<Order, Int>{

}
