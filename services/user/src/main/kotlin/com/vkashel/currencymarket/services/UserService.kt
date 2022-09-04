package com.vkashel.currencymarket.services

import com.vkashel.currencymarket.domain.User
import com.vkashel.currencymarket.domain.UserNotFoundException
import com.vkashel.currencymarket.repositories.UserRepository

class UserService(private val userRepository: UserRepository) {
    fun create(user: User): User = userRepository.create(user)

    fun find(id: Int): User? = userRepository.find(id)

    fun update(updateUser: User): User = userRepository.update(updateUser)
}