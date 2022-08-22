package com.vkashel.currencymarket.endpoints

import com.fasterxml.jackson.databind.ObjectMapper
import org.http4k.core.Body
import org.http4k.format.Jackson.auto

val createUserRequestLens = Body.auto<CreateUserRequest>().toLens()
val userMapper = ObjectMapper()