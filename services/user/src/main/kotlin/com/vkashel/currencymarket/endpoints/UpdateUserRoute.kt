package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.domain.UserNotFoundException
import com.vkashel.currencymarket.server.RestRoute
import com.vkashel.currencymarket.server.withJsonBody
import com.vkashel.currencymarket.services.UserService
import org.http4k.core.Body
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.format.Jackson.auto
import org.http4k.routing.path

class UpdateUserRoute(private val userService: UserService) : RestRoute {

    private val updateUserRequestLens = Body.auto<UpdateUserRequest>().toLens()

    override fun route(): List<RoutingHttpHandler> = listOf(
        "users/{id}" bind Method.PUT to ::update
    )

    private fun update(request: Request): Response {
        val id = request.path("id")?.toInt() ?: throw IllegalArgumentException("Request should contain id")
        val updateUser = updateUserRequestLens(request).toUser(id)
        return try {
            userService.update(updateUser).run {
                Response(Status.OK).withJsonBody(toResponse())
            }
        } catch (ex: UserNotFoundException) {
            Response(Status.NOT_FOUND)
        } catch (ex: Exception) {
            Response(Status.INTERNAL_SERVER_ERROR).body(ex.message ?: "")
        }
    }
}