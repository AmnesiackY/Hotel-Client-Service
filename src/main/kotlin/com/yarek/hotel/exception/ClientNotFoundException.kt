package com.yarek.hotel.exception

class ClientNotFoundException(id: Long) :
    ApplicationException("Client with id=$id not found")
