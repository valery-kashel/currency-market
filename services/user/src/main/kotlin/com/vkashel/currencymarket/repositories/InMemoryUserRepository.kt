package com.vkashel.currencymarket.repositories

import com.vkashel.currencymarket.domain.User
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

class InMemoryUserRepository : UserRepository {
    private val storage = ConcurrentHashMap<Int, User>()
    private val idGenerator = AtomicInteger(1)

    override fun create(user: User): User {
        val id = idGenerator.getAndIncrement()
        val userToSave = user.copy(id = id)
        storage[id] = userToSave
        return userToSave
    }

    override fun find(id: Int): User? = storage[id]
}