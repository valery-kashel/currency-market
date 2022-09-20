package com.vkashel.currencymarket.authentication

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.vkashel.currencymarket.common.User

class JWTProvider(secretKey: String) {
    private val algorithm = Algorithm.HMAC256(secretKey)
    private val issuer = "currency-market"
    private val jwtVerifier = JWT.require(algorithm)
        .withIssuer(issuer)
        .build()

    fun jwtFor(user: User): String = JWT.create()
        .withClaim("userId", user.id)
        .withClaim("email", user.email)
        .withClaim("username", user.username)
        .withIssuer(issuer)
        .sign(algorithm)

    fun verify(token: String): Boolean = try {
        jwtVerifier.verify(token)
        true
    } catch (ex: Exception) {
        false
    }
}