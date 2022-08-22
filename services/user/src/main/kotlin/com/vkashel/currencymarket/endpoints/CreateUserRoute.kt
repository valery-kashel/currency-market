package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.server.RestRoute
import com.vkashel.currencymarket.server.withJsonBody
import com.vkashel.currencymarket.services.UserService
import org.http4k.core.Method.POST
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind

class CreateUserRoute(private val userService: UserService) : RestRoute {
    override fun route(): List<RoutingHttpHandler> = listOf(
        "users" bind POST to ::create
    )

    private fun create(request: Request): Response {
        val createUserRequest = createUserRequestLens(request)
        val result = userService.create(createUserRequest.toUser())
        return Response(Status.OK).withJsonBody(result)
    }
}