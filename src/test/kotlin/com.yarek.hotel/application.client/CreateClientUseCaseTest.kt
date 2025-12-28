package com.yarek.hotel.application.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateClientUseCaseTest {

    @Test
    fun `should create client`() {
        // given: fake repository
        val fakeRepository = object : ClientRepository {

            override fun save(client: Client): Client =
                client.copy(id = 1L)

            override fun findById(id: Long): Client? =
                null
        }


        val useCase = CreateClientUseCase(fakeRepository)

        val client = Client(
            firstName = "John",
            lastName = "Doe",
            email = "john@test.com",
            phone = null
        )

        // when
        val result = useCase.execute(client)

        // then
        assertEquals(1L, result.id)
        assertEquals("John", result.firstName)
        assertEquals("Doe", result.lastName)
        assertEquals("john@test.com", result.email)
    }
}