package com.vkashel.currencymarket.user.endpoints

import com.vkashel.currencymarket.server.RestRoute
import com.vkashel.currencymarket.server.withJsonBody
import com.vkashel.currencymarket.user.services.UserService
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.path

class GetUserRoute(private val userService: UserService) : RestRoute {
    override fun route(): List<RoutingHttpHandler> = listOf(
        "users/{id}" bind Method.GET to ::get
    )

    private fun get(request: Request): Response {
        val id = request.path("id")?.toInt() ?: throw IllegalArgumentException("path should contain id")
        val user = userService.find(id)
        return user?.let { Response(Status.OK).withJsonBody(it.toResponse()) } ?: Response(Status.NOT_FOUND)
    }
}