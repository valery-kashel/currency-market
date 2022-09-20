package com.vkashel.currencymarket.authentication.fake

import com.vkashel.currencymarket.server.withJsonBody
import com.vkashel.currencymarket.user.api.UserPasswordResponse
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind
import org.http4k.routing.routes

class FakeUserClient {
    private val users = mutableListOf(
        UserPasswordResponse(
            id = 1,
            email = "test@gmail.com",
            password = "c3VwZXItc2VjcmV0LXBhc3N3b3Jk",
            username = "test"
        )
    )

    val routes = routes(
        "/users" bind Method.GET to {
            val pathParam = it.query("email") ?: Response(Status.NOT_FOUND)
            val response = users.firstOrNull { it.email == pathParam } ?: Response(Status.NOT_FOUND)
            Response(Status.OK).withJsonBody(response)
        }
    )
}