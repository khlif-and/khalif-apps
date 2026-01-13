package com.khalifapps.muslimgenz.domain.model

/**
 * Domain model for User
 */
data class User(
    val id: Int,
    val username: String,
    val email: String,
    val phone: String,
    val profilePicture: String,
    val isActivated: Boolean,
    val createdAt: String,
    val updatedAt: String
)
