package com.khalifapps.muslimgenz.presentation.viewmodel.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khalifapps.muslimgenz.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _uiState.update { it.copy(email = event.email, error = null) }
            }
            is LoginEvent.PasswordChanged -> {
                _uiState.update { it.copy(password = event.password, error = null) }
            }
            is LoginEvent.Login -> login()
            is LoginEvent.ClearError -> {
                _uiState.update { it.copy(error = null) }
            }
        }
    }

    private fun login() {
        val currentState = _uiState.value
        
        if (currentState.email.isBlank()) {
            _uiState.update { it.copy(error = "Email tidak boleh kosong") }
            return
        }
        
        if (currentState.password.isBlank()) {
            _uiState.update { it.copy(error = "Password tidak boleh kosong") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            
            loginUseCase(currentState.email, currentState.password)
                .onSuccess { authResult ->
                    _uiState.update { 
                        it.copy(
                            isLoading = false,
                            authResult = authResult,
                            isSuccess = true
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update { 
                        it.copy(
                            isLoading = false,
                            error = throwable.message ?: "Login gagal"
                        )
                    }
                }
        }
    }
}
