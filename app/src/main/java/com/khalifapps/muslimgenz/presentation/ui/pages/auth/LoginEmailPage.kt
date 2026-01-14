package com.khalifapps.muslimgenz.presentation.ui.pages.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.molecules.dialogs.ErrorDialog
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.EmailTextField
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.PasswordTextField
import com.khalifapps.muslimgenz.presentation.ui.pages.common.LoaderPage
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate
import com.khalifapps.muslimgenz.presentation.viewmodel.auth.LoginEvent
import com.khalifapps.muslimgenz.presentation.viewmodel.auth.LoginViewModel

@Composable
fun LoginEmailPage(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            onLoginSuccess()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AuthPageTemplate(
            headerContent = {
                AuthHeader(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = White)) {
                            append("Login Dengan Email\nKamu Gunakan.")
                        }
                    }
                )
            },
            content = {
                EmailTextField(
                    value = uiState.email,
                    onValueChange = { viewModel.onEvent(LoginEvent.EmailChanged(it)) },
                    label = "Email"
                )

                Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))

                PasswordTextField(
                    value = uiState.password,
                    onValueChange = { viewModel.onEvent(LoginEvent.PasswordChanged(it)) }
                )

                Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

                PrimaryButton(
                    text = "Login",
                    onClick = { viewModel.onEvent(LoginEvent.Login) },
                    modifier = Modifier
                )
            }
        )

        if (uiState.isLoading) {
            LoaderPage()
        }

        uiState.error?.let { error ->
            ErrorDialog(
                message = error,
                onDismiss = { viewModel.onEvent(LoginEvent.ClearError) }
            )
        }
    }
}


