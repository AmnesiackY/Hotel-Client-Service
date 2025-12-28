package com.yarek.hotel.dto

import jakarta.validation.constraints.NotBlank

data class ClientDto(
    val id: Long,

    @field:NotBlank(message = "First Name must not be blank")
    val firstName: String,

    @field:NotBlank(message = "Last Name must not be blank")
    val lastName: String,

    @field:NotBlank(message = "Email must not be blank")
    val email: String,

    val phone: String? = null
)
