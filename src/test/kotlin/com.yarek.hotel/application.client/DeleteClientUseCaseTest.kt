package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import com.yarek.hotel.exception.ClientNotFoundException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DeleteClientUseCaseTest {

    @Test
    fun `should delete client when exists`() {
        val repository = object : ClientRepository {
            override fun deleteById(id: Long): Boolean = true
            override fun save(client: Client): Client = client
            override fun findById(id: Long): Client? = null
            override fun findAll(): List<Client> =
                emptyList()
        }

        val useCase = DeleteClientUseCase(repository)

        // should not throw
        useCase.execute(1L)
    }

    @Test
    fun `should throw exception when client does not exist`() {
        val repository = object : ClientRepository {
            override fun deleteById(id: Long): Boolean = false
            override fun save(client: Client): Client = client
            override fun findById(id: Long): Client? = null
            override fun findAll(): List<Client> =
                emptyList()
        }

        val useCase = DeleteClientUseCase(repository)

        assertThrows<ClientNotFoundException> {
            useCase.execute(999L)
        }
    }
}