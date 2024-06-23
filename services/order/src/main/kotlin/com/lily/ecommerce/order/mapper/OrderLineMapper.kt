package com.lily.ecommerce.order.mapper

import com.lily.ecommerce.exception.BusinessException
import com.lily.ecommerce.order.OrderLine
import com.lily.ecommerce.order.controller.OrderLineResponse
import com.lily.ecommerce.order.service.OrderService
import com.lily.ecommerce.order.dto.OrderLineRequestDTO
import com.lily.ecommerce.order.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderLineMapper(val orderRepository: OrderRepository) {

    fun toOrderLine(request: OrderLineRequestDTO): OrderLine {
        return OrderLine(
            request.id,
            orderRepository.findById(request.orderId).orElseThrow { BusinessException("Order not found") },
            request.productId,
            request.quantity
        )
    }

    fun toOrderLineResponse(orderLine: OrderLine): OrderLineResponse {
        return OrderLineResponse(orderLine.id!!, orderLine.quantity)
    }

}
