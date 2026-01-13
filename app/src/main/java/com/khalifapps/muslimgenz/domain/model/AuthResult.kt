package com.khalifapps.muslimgenz.domain.model

/**
 * Domain model for authentication result
 */
data class AuthResult(
    val token: String,
    val refreshToken: String,
    val user: User,
    val message: String
)
