package com.vkashel.currencymarket.repositories

import com.vkashel.currencymarket.domain.User

interface UserRepository {
    fun create(user: User): User
}