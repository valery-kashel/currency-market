package com.vkashel.currencymarket

import com.vkashel.currencymarket.endpoints.CreateUserRoute
import com.vkashel.currencymarket.endpoints.HelloUserRoute
import com.vkashel.currencymarket.repositories.InMemoryUserRepository
import com.vkashel.currencymarket.server.RestServer
import com.vkashel.currencymarket.services.UserService

fun main() {
    val userRepository = InMemoryUserRepository()
    val userService = UserService(userRepository)
    val server = RestServer(
        HelloUserRoute(),
        CreateUserRoute(userService)
    )
    Runtime.getRuntime().addShutdownHook(Thread {
        server.stop()
    })
    server.start()
}