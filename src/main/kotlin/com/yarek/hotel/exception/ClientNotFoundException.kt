package com.yarek.hotel.exception

class ClientNotFoundException(id: Long) :
    RuntimeException("Client with id = $id not found")
