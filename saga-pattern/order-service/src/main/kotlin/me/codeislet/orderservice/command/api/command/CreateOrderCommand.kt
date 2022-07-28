package me.codeislet.orderservice.command.api.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class CreateOrderCommand(

    @TargetAggregateIdentifier
    val orderId: String,

    val productId: String,
    val userId: String,
    val addressId: String,
    val quantity: Int,
    val orderStatus: String
)
