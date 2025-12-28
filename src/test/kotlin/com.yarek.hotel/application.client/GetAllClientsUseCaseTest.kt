package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetAllClientsUseCaseTest {

    @Test
    fun `should return list of clients`() {
        val repository = object : ClientRepository {
            override fun findAll(): List<Client> =
                listOf(Client(1L, "John", "Doe", "a@b.com", null))

            override fun save(client: Client): Client = client
            override fun findById(id: Long): Client? = null
            override fun deleteById(id: Long): Boolean = false
        }

        val useCase = GetAllClientsUseCase(repository)

        val result = useCase.execute()

        assertEquals(1, result.size)
    }
}