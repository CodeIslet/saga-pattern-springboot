package me.codeislet.orderservice.command.api.controller

import me.codeislet.orderservice.command.api.command.CreateOrderCommand
import me.codeislet.orderservice.command.api.model.OrderRestModel
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/orders")
class OrderCommandController(val commandGateway: CommandGateway) {

    @PostMapping
    fun createOrder(@RequestBody orderRestModel: OrderRestModel): String {
        val orderId: String = UUID.randomUUID().toString()
        val createOrderCommand = CreateOrderCommand(
            orderId = orderId,
            productId = orderRestModel.productId,
            userId = "USER",
            addressId = orderRestModel.addressId,
            quantity = orderRestModel.quantity,
            orderStatus = "CREATED"
        )
        commandGateway.sendAndWait<CreateOrderCommand>(createOrderCommand)
        return "Order Created!"
    }
}
