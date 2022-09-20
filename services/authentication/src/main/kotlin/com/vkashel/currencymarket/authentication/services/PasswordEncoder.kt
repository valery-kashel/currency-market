package com.vkashel.currencymarket.authentication.services

interface PasswordEncoder {
    fun encode(password: String): String
    fun match(password: String, encodedPassword: String): Boolean
}