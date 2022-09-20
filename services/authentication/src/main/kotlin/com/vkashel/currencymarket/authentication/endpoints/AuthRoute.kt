package com.vkashel.currencymarket.authentication.endpoints

import com.vkashel.currencymarket.authentication.domain.BadCredentialsException
import com.vkashel.currencymarket.authentication.services.AuthService
import com.vkashel.currencymarket.server.RestRoute
import com.vkashel.currencymarket.server.withJsonBody
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind

class AuthRoute(private val authService: AuthService) : RestRoute {
    override fun route(): List<RoutingHttpHandler> = listOf(
        "auth" bind Method.POST to ::auth
    )

    private fun auth(request: Request): Response {
        val (email, password) = authRequestLens(request)
        return try {
            val token = authService.auth(email, password)
            Response(Status.OK).withJsonBody(JWTTokenResponse(token))
        } catch (ex: Exception) {
            when (ex) {
                is BadCredentialsException -> Response(Status.UNAUTHORIZED)
                else -> Response(Status.INTERNAL_SERVER_ERROR).body(ex.message ?: "")
            }
        }
    }
}