package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.repositories.InMemoryUserRepository
import com.vkashel.currencymarket.server.RestServer
import com.vkashel.currencymarket.server.withJsonBody
import com.vkashel.currencymarket.services.UserService
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.testing.Approver
import org.http4k.testing.JsonApprovalTest
import org.http4k.testing.assertApproved
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(JsonApprovalTest::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CreateUserRouteTest {

    private val userRepository = InMemoryUserRepository()
    private val userService = UserService(userRepository)
    private val route = CreateUserRoute(userService)
    private val app = RestServer(route).api

    private val userRequest = CreateUserRequest(
        email = "test@gmail.com",
        username = "test",
        password = "password"
    )

    @Test
    fun `should create user`(approver: Approver) {
        val request = Request(Method.POST, "/users").withJsonBody(userRequest)
        val response = app(request)
        assertEquals(Status.OK, response.status)
        approver.assertApproved(response, Status.OK)
    }
}