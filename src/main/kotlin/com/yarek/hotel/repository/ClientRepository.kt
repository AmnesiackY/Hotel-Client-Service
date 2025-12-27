package com.yarek.hotel.repository

import com.yarek.hotel.entity.ClientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<ClientEntity, Long>
