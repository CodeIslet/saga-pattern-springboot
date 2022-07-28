package me.codeislet.orderservice.command.api.event

import me.codeislet.orderservice.command.api.data.Order
import me.codeislet.orderservice.command.api.data.OrderRepository
import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class OrderEventHandler(val orderRepository: OrderRepository) {

    @EventHandler
    fun on(event: OrderCreatedEvent) {
        val order = Order(
            orderId = event.orderId,
            productId = event.productId,
            userId = event.userId,
            addressId = event.addressId,
            quantity = event.quantity,
            orderStatus = event.orderStatus
        )
        orderRepository.save(order)
    }
}
