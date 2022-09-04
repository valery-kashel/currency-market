package com.vkashel.currencymarket.user.repositories

import com.vkashel.currencymarket.user.domain.User
import com.vkashel.currencymarket.user.domain.UserNotFoundException
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

    override fun update(user: User): User {
        val existsUser = find(user.id) ?: throw UserNotFoundException(user.id)
        val newUser = existsUser.copy(
            username = user.username
        )
        storage[newUser.id] = newUser
        return newUser
    }
}