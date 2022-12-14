package com.vkashel.currencymarket.user.api

import org.http4k.core.Body
import org.http4k.format.Jackson.auto

val userResponseLens = Body.auto<UserPasswordResponse>().toLens()
val createUserRequestLens = Body.auto<CreateUserRequest>().toLens()