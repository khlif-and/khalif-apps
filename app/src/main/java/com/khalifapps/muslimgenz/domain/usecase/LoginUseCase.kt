package com.khalifapps.muslimgenz.domain.usecase

import com.khalifapps.muslimgenz.domain.model.AuthResult
import com.khalifapps.muslimgenz.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * Use case for login operation
 */
class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<AuthResult> {
        return authRepository.login(email, password)
    }
}
