package com.yarek.hotel.service

import org.springframework.stereotype.Service

@Service
class PingService {

    fun ping(): String = "ok"
}