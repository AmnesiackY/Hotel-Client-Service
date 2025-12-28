package com.yarek.hotel.api.client

import com.yarek.hotel.api.dto.ClientDto
import com.yarek.hotel.domain.client.Client

fun ClientDto.toDomain(): Client =
    Client(
        id = id ?: 0,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )

fun Client.toDto(): ClientDto =
    ClientDto(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )