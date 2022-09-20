package com.vkashel.currencymarket.authentication.services

import com.vkashel.currencymarket.authentication.JWTProvider
import com.vkashel.currencymarket.authentication.domain.BadCredentialsException
import com.vkashel.currencymarket.user.api.UserApi
import com.vkashel.currencymarket.user.api.toUser

class AuthService(
    private val userApi: UserApi,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JWTProvider

) {
    fun auth(email: String, password: String): String {
        val user = userApi.findUserWithPasswordByEmail(email)?.toUser() ?: throw BadCredentialsException()
        if (!passwordEncoder.match(password, user.password)) {
            throw BadCredentialsException()
        }
        return jwtProvider.jwtFor(user)
    }
}