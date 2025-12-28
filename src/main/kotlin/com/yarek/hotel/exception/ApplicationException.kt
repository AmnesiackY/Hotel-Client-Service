package com.yarek.hotel.exception

abstract class ApplicationException(
    message: String
) : RuntimeException(message)