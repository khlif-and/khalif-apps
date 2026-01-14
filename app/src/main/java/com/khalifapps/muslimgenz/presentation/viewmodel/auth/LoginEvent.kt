package com.khalifapps.muslimgenz.presentation.viewmodel.auth

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data object Login : LoginEvent()
    data object ClearError : LoginEvent()
}
