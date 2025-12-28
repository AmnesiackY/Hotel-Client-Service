package com.yarek.hotel.entity

import jakarta.persistence.*

@Entity
@Table(name = "clients")
class ClientEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(name = "phone")
    val phone: String? = null
)
