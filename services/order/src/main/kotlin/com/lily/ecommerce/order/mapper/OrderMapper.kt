package com.lily.ecommerce.order.mapper

import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.dto.OrderRequest
import org.springframework.stereotype.Service

@Service
class OrderMapper {
    fun toOrder(request: OrderRequest): Order {

        return Order(
            id = request.id,
            reference = request.reference,
            customerId = request.customerId,
            totalAmount = request.amount,
            paymentMethod = request.paymentMethod
        )


    }

}
