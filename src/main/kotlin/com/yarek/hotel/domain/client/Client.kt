package com.yarek.hotel.domain.client

data class Client(
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String?
)
