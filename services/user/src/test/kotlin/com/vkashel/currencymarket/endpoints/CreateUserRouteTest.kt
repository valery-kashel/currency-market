package com.vkashel.currencymarket.endpoints

import com.vkashel.currencymarket.UsersTestHelper
import com.vkashel.currencymarket.server.withJsonBody
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.testing.Approver
import org.http4k.testing.assertApproved
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CreateUserRouteTest : UsersTestHelper(){

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