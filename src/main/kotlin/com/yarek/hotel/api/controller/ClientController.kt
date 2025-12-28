package com.yarek.hotel.api.controller

import com.yarek.hotel.api.client.toDomain
import com.yarek.hotel.api.client.toDto
import com.yarek.hotel.api.dto.ClientDto
import com.yarek.hotel.application.client.CreateClientUseCase
import com.yarek.hotel.application.client.DeleteClientUseCase
import com.yarek.hotel.application.client.GetAllClientsUseCase
import com.yarek.hotel.application.client.GetClientByIdUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
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

    @Operation(summary = "Get client by id")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Client found"),
            ApiResponse(responseCode = "404", description = "Client not found")
        ]
    )
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ClientDto =
        getClientByIdUseCase.execute(id).toDto()

    @GetMapping
    fun getAll(): List<ClientDto> =
        getAllClientsUseCase.execute().map { it.toDto() }

    @Operation(summary = "Delete client by id")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "No Content"),
            ApiResponse(responseCode = "404", description = "Client not found")
        ]
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        deleteClientUseCase.execute(id)
    }
}
