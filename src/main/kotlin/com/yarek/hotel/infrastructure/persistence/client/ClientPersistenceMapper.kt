package com.yarek.hotel.infrastructure.persistence.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.entity.ClientEntity

fun Client.toEntity(): ClientEntity =
    ClientEntity(
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )

fun ClientEntity.toDomain(): Client =
    Client(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )