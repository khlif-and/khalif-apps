package com.khalifapps.muslimgenz.domain.repository

import com.khalifapps.muslimgenz.domain.model.AuthResult

/**
 * Repository interface for authentication operations
 */
interface AuthRepository {
    suspend fun login(email: String, password: String): Result<AuthResult>
}
