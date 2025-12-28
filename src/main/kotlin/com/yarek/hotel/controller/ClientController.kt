package com.yarek.hotel.controller

import com.yarek.hotel.api.client.toDomain
import com.yarek.hotel.application.client.CreateClientUseCase
import com.yarek.hotel.application.client.DeleteClientUseCase
import com.yarek.hotel.application.client.GetAllClientsUseCase
import com.yarek.hotel.application.client.GetClientByIdUseCase
import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.dto.ClientDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clients")
class ClientController(
    private val createClientUseCase: CreateClientUseCase,
    private val getClientByIdUseCase: GetClientByIdUseCase,
    private val deleteClientUseCase: DeleteClientUseCase,
    private val getAllClientsUseCase: GetAllClientsUseCase
) {

    @PostMapping
    fun create(@RequestBody dto: ClientDto): ClientDto =
        createClientUseCase.execute(dto.toDomain()).toDto()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ClientDto =
        getClientByIdUseCase.execute(id).toDto()

    @GetMapping
    fun getAll(): List<ClientDto> =
        getAllClientsUseCase.execute().map { it.toDto() }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        deleteClientUseCase.execute(id)
    }

    fun Client.toDto(): ClientDto = ClientDto(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phone = phone
    )
}
