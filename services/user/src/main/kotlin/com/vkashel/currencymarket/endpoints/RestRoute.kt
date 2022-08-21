package com.vkashel.currencymarket.endpoints

import org.http4k.routing.RoutingHttpHandler

interface RestRoute {
    fun route(): List<RoutingHttpHandler>
}