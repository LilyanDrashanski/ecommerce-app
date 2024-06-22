package com.lily.ecommerce.order.service

import com.lily.ecommerce.order.controller.OrderLineResponse
import com.lily.ecommerce.order.dto.OrderLineRequestDTO
import com.lily.ecommerce.order.mapper.OrderLineMapper
import com.lily.ecommerce.order.repository.OrderLineRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class OrderLineService(
    val repository: OrderLineRepository,
    val mapper: OrderLineMapper
) {


    fun saveOrderLine(orderLineRequest: OrderLineRequestDTO): Int? {
        val order = mapper.toOrderLine(orderLineRequest)
        return repository.save(order).id
    }

    fun findAllByOrderId(orderId: Int): List<OrderLineResponse> {
        return repository.findAllByOrderId(orderId)
            .stream()
            .map(mapper::toOrderLineResponse)
            .collect(Collectors.toList())
    }

}
