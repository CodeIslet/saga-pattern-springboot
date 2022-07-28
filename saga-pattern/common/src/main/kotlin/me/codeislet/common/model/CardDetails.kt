package me.codeislet.common.model

data class CardDetails(
    val name: String,
    val cardNumber: String,
    val validUntilMonth: Int,
    val validUntilYear: Int,
    val cvv: Int
)
