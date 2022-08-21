package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.server.RestRoute
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.bind

class HelloUserRoute : RestRoute {
    override fun route() = listOf(
        "hello" bind Method.GET to {
            Response(Status.OK)
                .body("Hello, ${it.query("name")}")
        }
    )
}