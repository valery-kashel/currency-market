package com.vkashel.currencymarket.user.endpoints

import com.vkashel.currencymarket.server.RestRoute
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind

class HelloRoute: RestRoute {
    override fun route(): List<RoutingHttpHandler> = listOf(
        "hello" bind Method.GET to ::hello
    )

    private fun hello(request: Request): Response{
        return Response(Status.OK).body("Hello from User service")
    }
}