package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import org.springframework.stereotype.Component

@Component
class CreateClientUseCase(
    private val repository: ClientRepository
) {
    fun execute(client: Client): Client =
        repository.save(client)
}