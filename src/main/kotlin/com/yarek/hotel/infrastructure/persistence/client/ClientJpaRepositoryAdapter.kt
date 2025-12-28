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

    override fun findById(id: Long): Client? =
        jpaRepository.findById(id)
            .orElse(null)
            ?.toDomain()

    override fun deleteById(id: Long): Boolean =
        if (jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id)
            true
        } else {
            false
        }
}