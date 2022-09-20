package com.vkashel.currencymarket.user.api

import com.vkashel.currencymarket.common.User

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

data class UserPasswordResponse(
    val id: Int,
    val email: String,
    val username: String,
    val password: String
)

data class UpdateUserRequest(
    val username: String
)

fun UpdateUserRequest.toUser(id: Int): User = User(
    username = username,
    email = "",
    password = "",
    id = id
)

fun CreateUserRequest.toUser(): User = User(
    email = email,
    password = password,
    username = username
)

fun User.toResponse(): UserResponse = UserResponse(
    id = id,
    email = email,
    username = username
)

fun UserPasswordResponse.toUser(): User = User(
    id = id,
    email = email,
    password = password,
    username = username
)