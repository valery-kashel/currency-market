package com.vkashel.currencymarket.user.api

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request

class UsersApi(private val http: HttpHandler) {
    fun findUserByEmail(email: String): UserResponse {
        val request = Request(Method.GET, "/users?email=$email")
        val response = http(request)
        return userResponseLens(response)
    }
}