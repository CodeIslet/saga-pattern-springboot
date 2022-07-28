package me.codeislet.orderservice.command.api.data

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, String>
