package com.yarek.hotel.infrastructure.persistence.client

import com.yarek.hotel.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientJpaRepository : JpaRepository<ClientEntity, Long>
