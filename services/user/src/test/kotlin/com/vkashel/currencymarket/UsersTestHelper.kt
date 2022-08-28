package com.vkashel.currencymarket

import com.vkashel.currencymarket.domain.User
import com.vkashel.currencymarket.endpoints.CreateUserRoute
import com.vkashel.currencymarket.endpoints.GetUserRoute
import com.vkashel.currencymarket.repositories.InMemoryUserRepository
import com.vkashel.currencymarket.server.RestServer
import com.vkashel.currencymarket.services.UserService
import org.http4k.testing.JsonApprovalTest
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(JsonApprovalTest::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class UsersTestHelper {
    protected val userRepository = InMemoryUserRepository()
    protected val userService = UserService(userRepository)
    private val createUserRoute = CreateUserRoute(userService)
    private val getUserRoute = GetUserRoute(userService)
    protected val app = RestServer(createUserRoute, getUserRoute).api

    protected fun createUser(): User = userRepository.create(
        User(
            username = "test",
            password = "123",
            email = "test@gmail.com"
        )
    )
}