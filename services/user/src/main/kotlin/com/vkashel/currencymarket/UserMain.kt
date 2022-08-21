package com.vkashel.currencymarket

import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main() {
    val app = { request: Request ->
        Response(Status.OK)
            .body("Hello, ${request.query("name")}")
    }

    app.asServer(Jetty(8080)).start()
}