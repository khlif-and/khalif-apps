package com.khalifapps.muslimgenz.data.remote.auth.dto

import com.google.gson.annotations.SerializedName

/**
 * Login response wrapper matching API response structure:
 * {
 *   "data": { ... },
 *   "message": "login successful"
 * }
 */
data class LoginResponse(
    @SerializedName("data")
    val data: LoginData,
    @SerializedName("message")
    val message: String
)

data class LoginData(
    @SerializedName("token")
    val token: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user")
    val user: UserDto
)

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("profile_picture")
    val profilePicture: String,
    @SerializedName("is_activated")
    val isActivated: Boolean,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)
