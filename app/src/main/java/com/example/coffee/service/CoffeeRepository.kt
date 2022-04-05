package com.example.coffee.service


class CoffeeRepository(private val service:CoffeeService) {

    suspend fun getResults () = service.getResults()
}