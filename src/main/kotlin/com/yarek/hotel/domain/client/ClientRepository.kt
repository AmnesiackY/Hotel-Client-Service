package com.yarek.hotel.domain.client

interface ClientRepository {
    fun save(client: Client): Client
    fun findById(id: Long): Client?
}