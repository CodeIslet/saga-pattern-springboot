package me.codeislet.orderservice.command.api.aggregate

import me.codeislet.orderservice.command.api.command.CreateOrderCommand
import me.codeislet.orderservice.command.api.event.OrderCreatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class OrderAggregate {

    @AggregateIdentifier
    var orderId: String? = null

    var productId: String? = null
    var userId: String? = null
    var addressId: String? = null
    var quantity: Int? = null
    var orderStatus: String? = null

    @CommandHandler
    constructor(createOrderCommand: CreateOrderCommand) {
        val orderCreatedEvent = OrderCreatedEvent(
            orderId = createOrderCommand.orderId,
            productId = createOrderCommand.productId,
            userId = createOrderCommand.userId,
            addressId = createOrderCommand.addressId,
            quantity = createOrderCommand.quantity,
            orderStatus = createOrderCommand.orderStatus
        )
        AggregateLifecycle.apply(orderCreatedEvent)
    }

    @EventSourcingHandler
    fun on(orderCreatedEvent: OrderCreatedEvent) {
        this.orderId = orderCreatedEvent.orderId
        this.productId = orderCreatedEvent.productId
        this.userId = orderCreatedEvent.userId
        this.addressId = orderCreatedEvent.addressId
        this.quantity = orderCreatedEvent.quantity
        this.orderStatus = orderCreatedEvent.orderStatus
    }
}