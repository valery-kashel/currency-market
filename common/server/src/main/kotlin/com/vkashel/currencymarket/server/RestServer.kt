package com.vkashel.currencymarket.server

import org.http4k.core.Method
import org.http4k.core.then
import org.http4k.filter.AllowAll
import org.http4k.filter.CorsPolicy
import org.http4k.filter.OriginPolicy
import org.http4k.filter.ServerFilters
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty

class RestServer(vararg restRoutes: RestRoute) {
    val api: RoutingHttpHandler = ServerFilters.Cors(
        CorsPolicy(
            originPolicy = OriginPolicy.AllowAll(),
            headers = listOf("*"),
            methods = Method.values().toList(),
            credentials = true
        )
    ).then(
        routes(
            *restRoutes.flatMap { it.route() }
                .toTypedArray()
        )
    )

    private val server: Http4kServer = Jetty(8080).toServer(api)

    fun start() = server.start()

    fun stop() = server.stop()
}