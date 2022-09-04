package com.vkashel.currencymarket.user.repositories

import com.vkashel.currencymarket.user.domain.User

interface UserRepository {
    fun create(user: User): User
    fun find(id: Int): User?
    fun update(user: User): User
}