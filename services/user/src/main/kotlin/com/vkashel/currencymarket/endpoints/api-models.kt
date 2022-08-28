package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.domain.User

data class CreateUserRequest(
    val email: String,
    val password: String,
    val username: String
)

fun CreateUserRequest.toUser(): User = User(
    email = email,
    password = password,
    username = username
)

data class UserResponse(
    val id: Int,
    val email: String,
    val username: String
)

fun User.toResponse(): UserResponse = UserResponse(
    id = id,
    email = email,
    username = username
)