package com.vkashel.currencymarket.authentication.endpoints

data class AuthRequest(
    val email: String,
    val password: String,
)

data class JWTTokenResponse(
    val token: String
)