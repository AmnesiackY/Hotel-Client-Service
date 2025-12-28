package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import com.yarek.hotel.exception.ClientNotFoundException
import org.springframework.stereotype.Component

@Component
class GetClientByIdUseCase(
    private val repository: ClientRepository
) {
    fun execute(id: Long): Client =
        repository.findById(id)
            ?: throw ClientNotFoundException(id)
}