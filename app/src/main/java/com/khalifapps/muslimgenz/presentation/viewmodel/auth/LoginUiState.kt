package com.khalifapps.muslimgenz.presentation.viewmodel.auth

import com.khalifapps.muslimgenz.domain.model.AuthResult

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val authResult: AuthResult? = null,
    val isSuccess: Boolean = false
)
