package com.vkashel.currencymarket.user

import com.vkashel.currencymarket.user.endpoints.CreateUserRoute
import com.vkashel.currencymarket.user.endpoints.GetUserRoute
import com.vkashel.currencymarket.user.endpoints.UpdateUserRoute
import com.vkashel.currencymarket.user.repositories.InMemoryUserRepository
import com.vkashel.currencymarket.server.RestServer
import com.vkashel.currencymarket.user.endpoints.HelloRoute
import com.vkashel.currencymarket.user.services.UserService

fun main() {
    val userRepository = InMemoryUserRepository()
    val userService = UserService(userRepository)
    RestServer(
        CreateUserRoute(userService),
        GetUserRoute(userService),
        UpdateUserRoute(userService),
        HelloRoute()
    )
        .addShutdownHook()
        .start()
}