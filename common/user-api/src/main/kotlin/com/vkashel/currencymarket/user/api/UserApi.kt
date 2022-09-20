package com.vkashel.currencymarket.user.api

import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status

class UserApi(private val http: HttpHandler) {
    fun findUserWithPasswordByEmail(email: String): UserPasswordResponse? {
        val request = Request(Method.GET, "/users?email=$email")
        val response = http(request)
        if (response.status == Status.NOT_FOUND) {
            return null
        }
        return userResponseLens(response)
    }
}