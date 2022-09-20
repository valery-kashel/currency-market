package com.vkashel.currencymarket.authentication

import com.vkashel.currencymarket.authentication.endpoints.AuthRoute
import com.vkashel.currencymarket.authentication.fake.FakeUserClient
import com.vkashel.currencymarket.authentication.services.AuthService
import com.vkashel.currencymarket.authentication.services.Base64PasswordEncoder
import com.vkashel.currencymarket.server.RestServer
import com.vkashel.currencymarket.user.api.UserApi

fun main() {
    val userApi = UserApi(FakeUserClient.routes)
    val authService = AuthService(userApi, Base64PasswordEncoder(), JWTProvider("super-secret-key"))
    RestServer(
        AuthRoute(authService)
    )
        .addShutdownHook()
        .start()
}