package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import org.springframework.stereotype.Component

@Component
class GetAllClientsUseCase(
    private val repository: ClientRepository
) {
    fun execute(): List<Client> =
        repository.findAll()
}