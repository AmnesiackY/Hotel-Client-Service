package com.yarek.hotel.service

import com.yarek.hotel.dto.ClientDto
import com.yarek.hotel.entity.ClientEntity
import com.yarek.hotel.exception.ClientNotFoundException
import com.yarek.hotel.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
    private val repository: ClientRepository
) {

    fun create(dto: ClientDto): ClientDto {
        val entity = ClientEntity(
            firstName = dto.firstName,
            lastName = dto.lastName,
            email = dto.email,
            phone = dto.phone
        )
        return repository.save(entity).toDto()
    }

    fun get(id: Long): ClientDto =
        repository.findById(id)
            .map { it.toDto() }
            .orElseThrow { ClientNotFoundException(id) }

    fun getAll(): List<ClientDto> =
        repository.findAll().map { it.toDto() }

    fun delete(id: Long) {
        if (!repository.existsById(id)) {
            throw ClientNotFoundException(id)
        }
        repository.deleteById(id)
    }

    private fun ClientEntity.toDto() =
        ClientDto(
            id = id,
            firstName = firstName,
            lastName = lastName,
            email = email,
            phone = phone
        )
}
