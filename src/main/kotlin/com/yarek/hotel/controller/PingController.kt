package com.yarek.hotel.controller

import com.yarek.hotel.service.PingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController(
    private val pingService: PingService
) {

    @GetMapping("/ping")
    fun ping(): String = pingService.ping()
}