package com.lily.ecommerce.order.service

import com.lily.ecommerce.customer.CustomerClient
import com.lily.ecommerce.exception.BusinessException
import com.lily.ecommerce.order.Order
import com.lily.ecommerce.order.dto.OrderLineRequestDTO
import com.lily.ecommerce.order.dto.OrderRequestDTO
import com.lily.ecommerce.order.dto.OrderResponseDTO
import com.lily.ecommerce.order.kafka.OrderConfirmation
import com.lily.ecommerce.order.kafka.OrderProducer
import com.lily.ecommerce.order.mapper.OrderMapper
import com.lily.ecommerce.order.repository.OrderRepository
import com.lily.ecommerce.payment.PaymentClient
import com.lily.ecommerce.payment.PaymentRequestDTO
import com.lily.ecommerce.product.ProductClient
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class OrderService(
    private val customerClient: CustomerClient,
    private val productClient: ProductClient,
    private val orderRepository: OrderRepository,
    private val mapper: OrderMapper,
    private val orderLineService: OrderLineService,
    private val orderProducer: OrderProducer,
    private val paymentClient: PaymentClient,
) {
    fun createdOrder(request: OrderRequestDTO): Order? {

        val customer = customerClient.findCustomerById(request.customerId)
            .orElseThrow { BusinessException("Cannot create order: Customer not found") }


        val purchasedProducts = productClient.purchaseProducts(request.products)

        val order = orderRepository.save(mapper.toOrder(request))

        for (purchaseRequest in request.products!!) {
            orderLineService.saveOrderLine(
                OrderLineRequestDTO(
                    null,
                    order.id,
                    purchaseRequest.productId,
                    purchaseRequest.quantity,
                )
            )
        }

        val paymentRequest = PaymentRequestDTO(
            amount = request.amount,
            paymentMethod = request.paymentMethod,
            orderId = order.id,
            orderReference = order.reference,
            customer = customer
        )

        paymentClient.requestOrderPayment(paymentRequest)

        orderProducer.sendOrderConfirmation(
            OrderConfirmation(
                request.reference,
                request.amount,
                request.paymentMethod,
                customer,
                purchasedProducts
            )
        )


        return order
    }


    fun getOrderById(orderId: Int): Order {
        return orderRepository.findById(orderId)
            .orElseThrow { BusinessException("Order not found") }
    }

    fun findAll(): List<OrderResponseDTO>? {
        return orderRepository.findAll()
            .stream()
            .map(mapper::fromOrder)
            .collect(Collectors.toList())
    }

    fun findById(orderId: Int): OrderResponseDTO? {
        return orderRepository.findById(orderId)
            .map(mapper::fromOrder)
            .orElseThrow { EntityNotFoundException("Order $orderId not found") }
    }


}
