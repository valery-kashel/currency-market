package com.vkashel.currencymarket.authentication.services

import java.util.*

class Base64PasswordEncoder: PasswordEncoder {
    override fun encode(password: String): String = Base64.getEncoder().encodeToString(password.toByteArray())

    override fun match(password: String, encodedPassword: String): Boolean = encode(password) == encodedPassword
}