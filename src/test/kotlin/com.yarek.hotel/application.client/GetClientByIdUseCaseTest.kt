package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import com.yarek.hotel.exception.ClientNotFoundException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GetClientByIdUseCaseTest {

    @Test
    fun `should return client when found`() {
        val repository = object : ClientRepository {
            override fun findById(id: Long): Client? =
                Client(id = 1L, firstName = "John", lastName = "Doe", email = "a@b.com", phone = null)

            override fun save(client: Client): Client = client
        }

        val useCase = GetClientByIdUseCase(repository)

        val result = useCase.execute(1L)

        assertEquals(1L, result.id)
    }

    @Test
    fun `should throw exception when client not found`() {
        val repository = object : ClientRepository {
            override fun findById(id: Long): Client? = null
            override fun save(client: Client): Client = client
        }

        val useCase = GetClientByIdUseCase(repository)

        assertThrows<ClientNotFoundException> {
            useCase.execute(99L)
        }
    }

}
