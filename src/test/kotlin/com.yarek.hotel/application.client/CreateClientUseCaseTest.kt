package com.yarek.hotel.application.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateClientUseCaseTest {

    @Test
    fun `should create client`() {
        // given: fake repository
        val fakeRepository = object : com.yarek.hotel.domain.client.ClientRepository {
            override fun save(client: com.yarek.hotel.domain.client.Client): com.yarek.hotel.domain.client.Client =
                client.copy(id = 1L)
        }

        val useCase = com.yarek.hotel.application.client.CreateClientUseCase(fakeRepository)

        val input = com.yarek.hotel.domain.client.Client(
            firstName = "John",
            lastName = "Doe",
            email = "john@test.com",
            phone = null
        )

        // when
        val result = useCase.execute(input)

        // then
        assertEquals(1L, result.id)
        assertEquals("John", result.firstName)
        assertEquals("Doe", result.lastName)
        assertEquals("john@test.com", result.email)
    }
}