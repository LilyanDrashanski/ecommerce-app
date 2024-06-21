package com.lily.ecommerce.order.service

import com.lily.ecommerce.order.dto.OrderLineRequest
import com.lily.ecommerce.order.mapper.OrderLineMapper
import com.lily.ecommerce.order.repository.OrderLineRepository
import org.springframework.stereotype.Service

@Service
class OrderLineService(
    val repository: OrderLineRepository,
    val mapper: OrderLineMapper
) {


    fun saveOrderLine(orderLineRequest: OrderLineRequest): Int? {
        val order = mapper.toOrderLine(orderLineRequest)
        return repository.save(order).id
    }

}
