package com.vkashel.currencymarket

import com.vkashel.currencymarket.endpoints.HelloUserRoute
import com.vkashel.currencymarket.endpoints.RestServer

fun main() {
    RestServer(
        HelloUserRoute()
    ).start()
}