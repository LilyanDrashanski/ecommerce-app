package com.lily.ecommerce.order.mapper

import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.dto.OrderRequestDTO
import com.lily.ecommerce.order.dto.OrderResponseDTO
import org.springframework.stereotype.Service

@Service
class OrderMapper {
    fun toOrder(request: OrderRequestDTO): Order {

        return Order(
            id = request.id,
            reference = request.reference,
            customerId = request.customerId,
            totalAmount = request.amount,
            paymentMethod = request.paymentMethod
        )


    }

    fun fromOrder(order: Order): OrderResponseDTO {
        return OrderResponseDTO(
            id = order.id,
            reference = order.reference,
            amount = order.totalAmount,
            paymentMethod = order.paymentMethod,
            customerId = order.customerId
        )
    }

}
