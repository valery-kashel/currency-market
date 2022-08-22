package com.vkashel.currencymarket.server

import org.http4k.core.ContentType
import org.http4k.core.Request
import org.http4k.core.Response

fun Request.withJsonBody(obj: Any): Request = body(mapper.writeValueAsString(obj))

fun Response.withJsonBody(obj: Any): Response = header("Content-Type", ContentType.APPLICATION_JSON.toHeaderValue())
    .body(mapper.writeValueAsString(obj))