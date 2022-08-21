package com.vkashel.currencymarket.server

import org.http4k.routing.RoutingHttpHandler

interface RestRoute {
    fun route(): List<RoutingHttpHandler>
}