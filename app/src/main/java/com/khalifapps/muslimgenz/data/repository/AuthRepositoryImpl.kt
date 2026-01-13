package com.khalifapps.muslimgenz.data.repository

import com.khalifapps.muslimgenz.data.remote.auth.AuthApiHelper
import com.khalifapps.muslimgenz.data.remote.auth.dto.LoginRequest
import com.khalifapps.muslimgenz.domain.model.AuthResult
import com.khalifapps.muslimgenz.domain.model.User
import com.khalifapps.muslimgenz.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * Implementation of AuthRepository
 */
class AuthRepositoryImpl @Inject constructor(
    private val authApiHelper: AuthApiHelper
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<AuthResult> {
        return try {
            val response = authApiHelper.login(LoginRequest(email, password))
            if (response.isSuccessful) {
                response.body()?.let { loginResponse ->
                    val user = User(
                        id = loginResponse.data.user.id,
                        username = loginResponse.data.user.username,
                        email = loginResponse.data.user.email,
                        phone = loginResponse.data.user.phone,
                        profilePicture = loginResponse.data.user.profilePicture,
                        isActivated = loginResponse.data.user.isActivated,
                        createdAt = loginResponse.data.user.createdAt,
                        updatedAt = loginResponse.data.user.updatedAt
                    )
                    val authResult = AuthResult(
                        token = loginResponse.data.token,
                        refreshToken = loginResponse.data.refreshToken,
                        user = user,
                        message = loginResponse.message
                    )
                    Result.success(authResult)
                } ?: Result.failure(Exception("Response body is null"))
            } else {
                Result.failure(Exception("Login failed: ${response.code()} - ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
