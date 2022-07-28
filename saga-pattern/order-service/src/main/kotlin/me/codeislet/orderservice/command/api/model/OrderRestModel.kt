package me.codeislet.orderservice.command.api.model

data class OrderRestModel(
    val productId: String,
    val userId: String,
    val addressId: String,
    val quantity: Int
)
