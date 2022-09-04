package com.vkashel.currencymarket.user.api

data class CreateUserRequest(
    val email: String,
    val password: String,
    val username: String
)

data class UserResponse(
    val id: Int,
    val email: String,
    val username: String
)

data class UpdateUserRequest(
    val username: String
)