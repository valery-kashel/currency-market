package com.vkashel.currencymarket.user.domain

data class User(
    val id: Int = 0,
    val email: String,
    val password: String,
    val username: String
)

data class UserNotFoundException(val id: Int) : RuntimeException("User was not found by id = $id")