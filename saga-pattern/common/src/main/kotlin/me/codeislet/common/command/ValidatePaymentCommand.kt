package me.codeislet.common.command

import me.codeislet.common.model.CardDetails

data class ValidatePaymentCommand(val paymentId: String, val orderId: String, val cardDetails: CardDetails)
