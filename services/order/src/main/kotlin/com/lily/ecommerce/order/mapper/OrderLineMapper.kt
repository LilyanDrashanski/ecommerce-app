package com.lily.ecommerce.order.mapper

import com.lily.ecommerce.order.OrderLine
import com.lily.ecommerce.order.controller.OrderLineResponse
import com.lily.ecommerce.order.service.OrderService
import com.lily.ecommerce.order.dto.OrderLineRequestDTO
import org.springframework.stereotype.Service

@Service
class OrderLineMapper {
    lateinit var orderService: OrderService

    fun toOrderLine(request: OrderLineRequestDTO): OrderLine {
        return OrderLine(
            request.id,
            orderService.getOrderById(request.orderId),
            request.productId,
            request.quantity)
    }

    fun toOrderLineResponse(orderLine: OrderLine): OrderLineResponse {
            return  OrderLineResponse(orderLine.id!!, orderLine.quantity)
    }

}
