package com.vkashel.currencymarket.user.services

import com.vkashel.currencymarket.common.User
import com.vkashel.currencymarket.user.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {
    fun create(user: User): User = userRepository.create(user)

    fun find(id: Int): User? = userRepository.find(id)

    fun update(updateUser: User): User = userRepository.update(updateUser)
}