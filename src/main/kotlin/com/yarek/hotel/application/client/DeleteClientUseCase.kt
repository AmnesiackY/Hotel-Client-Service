package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.ClientRepository
import com.yarek.hotel.exception.ClientNotFoundException
import org.springframework.stereotype.Component

@Component
class DeleteClientUseCase(
    private val repository: ClientRepository
) {
    fun execute(id: Long) {
        if (!repository.deleteById(id)) {
            throw ClientNotFoundException(id)
        }
    }
}