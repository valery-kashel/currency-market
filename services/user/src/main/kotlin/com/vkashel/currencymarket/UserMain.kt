package com.vkashel.currencymarket

import com.vkashel.currencymarket.endpoints.HelloUserRoute
import com.vkashel.currencymarket.server.RestServer

fun main() {
    RestServer(
        HelloUserRoute()
    ).start()
}