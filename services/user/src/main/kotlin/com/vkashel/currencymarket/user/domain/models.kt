package com.vkashel.currencymarket.user.domain

data class UserNotFoundException(val id: Int) : RuntimeException("User was not found by id = $id")