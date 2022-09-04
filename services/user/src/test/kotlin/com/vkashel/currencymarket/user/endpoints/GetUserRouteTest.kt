package com.vkashel.currencymarket.user.endpoints

import com.vkashel.currencymarket.UsersTestHelper
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status
import org.http4k.testing.Approver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GetUserRouteTest : UsersTestHelper() {

    @Test
    fun `should return user by id`(approver: Approver) {
        val user = createUser()
        val request = Request(Method.GET, "/users/${user.id}")
        val response = app(request)
        assertEquals(Status.OK, response.status)
        approver.assertApproved(response)
    }
}