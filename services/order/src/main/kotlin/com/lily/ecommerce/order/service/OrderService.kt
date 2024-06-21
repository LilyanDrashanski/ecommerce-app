package com.lily.ecommerce.order.service

import com.lily.ecommerce.customer.CustomerClient
import com.lily.ecommerce.exception.BusinessException
import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.dto.OrderLineRequest
import com.lily.ecommerce.order.dto.OrderRequest
import com.lily.ecommerce.order.mapper.OrderMapper
import com.lily.ecommerce.order.repository.OrderRepository
import com.lily.ecommerce.product.ProductClient
import org.springframework.stereotype.Service

@Service
class OrderService(
    val customerClient: CustomerClient,
    val productClient: ProductClient,
    val orderRepository: OrderRepository,
    val mapper: OrderMapper,
    val orderLineService: OrderLineService
) {
    fun createdOrder(request: OrderRequest): Order {
        //check the customer ->> OpenFeign

        var customer = customerClient.findCustomerById(request.customerId)
            .orElseThrow { BusinessException("Cannot create order: Customer not found") }


        // purchase the products ->> product-ms

        productClient.purchaseProducts(request.products)

        var order = orderRepository.save(mapper.toOrder(request))

        for (purchaseRequest in request.products){
            orderLineService.saveOrderLine(
                OrderLineRequest(
                    null,
                    order.id,
                    purchaseRequest.productId,
                    purchaseRequest.quantity,
                )
            )
        }
        //persist order

        // persist order lines

        // start payment process

        // send the order confirmation ->> notification-ms
    }


    fun getOrderById(orderId: Int): Order {
        return orderRepository.findById(orderId)
            .orElseThrow{ BusinessException("Order not found") }
    }


}
