package me.codeislet.orderservice.command.api.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "orders")
class Order(
    @Id
    val orderId: String? = null,
    val productId: String? = null,
    val userId: String? = null,
    val addressId: String? = null,
    val quantity: Int? = null,
    val orderStatus: String? = null
)
