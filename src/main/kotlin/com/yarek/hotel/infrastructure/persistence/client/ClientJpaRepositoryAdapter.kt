package com.yarek.hotel.infrastructure.persistence.client

import com.yarek.hotel.domain.client.Client
import com.yarek.hotel.domain.client.ClientRepository
import org.springframework.stereotype.Repository

@Repository
class ClientJpaRepositoryAdapter(
    private val jpaRepository: ClientJpaRepository
) : ClientRepository {

    override fun save(client: Client): Client =
        jpaRepository.save(client.toEntity()).toDomain()
}