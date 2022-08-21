package com.vkashel.currencymarket.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

class JWTProvider(secretKey: String) {
    private val algorithm = Algorithm.HMAC256(secretKey)
    private val issuer = "currency-market"
    private val jwtVerifier = JWT.require(algorithm)
        .withIssuer(issuer)
        .build()

    fun jwtFor(user: Map<String, String>): String = JWT.create()
        .withClaim("userId", user["id"])
        .withIssuer(issuer)
        .sign(algorithm)

    fun verify(token: String): Boolean = try {
        jwtVerifier.verify(token)
        true
    } catch (ex: Exception) {
        false
    }
}