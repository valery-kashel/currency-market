package com.vkashel.currencymarket.endpoints

import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

class RestServer(private vararg val restRoutes: RestRoute) {
    private val server = Jetty(8080)

    fun start() = routes(
        *restRoutes.flatMap { it.route() }
            .toTypedArray()
    )
        .asServer(server)
        .start()
}