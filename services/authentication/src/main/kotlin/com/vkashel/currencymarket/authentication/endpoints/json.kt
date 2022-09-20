package com.vkashel.currencymarket.authentication.endpoints

import org.http4k.core.Body
import org.http4k.format.Jackson.auto

val authRequestLens = Body.auto<AuthRequest>().toLens()