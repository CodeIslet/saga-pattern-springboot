package me.codeislet.orderservice.command.api.saga

import me.codeislet.orderservice.command.api.event.OrderCreatedEvent
import org.axonframework.modelling.saga.SagaEventHandler
import org.axonframework.modelling.saga.StartSaga
import org.axonframework.spring.stereotype.Saga

@Saga
class OrderProcessingSaga {

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    fun handle(orderCreatedEvent: OrderCreatedEvent) {
        println("Order Created Event in Saga for Order Id: ${orderCreatedEvent.orderId}")
    }
}
