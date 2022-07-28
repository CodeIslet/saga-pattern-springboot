package me.codeislet.orderservice.command.api.event

data class OrderCreatedEvent(
    val orderId: String,
    val productId: String,
    val userId: String,
    val addressId: String,
    val quantity: Int,
    val orderStatus: String
)
