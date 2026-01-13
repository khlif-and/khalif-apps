package com.khalifapps.muslimgenz.presentation.ui.pages.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.inputs.InputTextField
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.EmailTextField
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.PasswordTextField
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.AuthTextField
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate

@Composable
fun RegisterEmailPage(
    onRegisterSuccess: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    AuthPageTemplate(
        headerContent = {
            AuthHeader(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = White)) {
                        append("Daftar Akun\n")
                    }
                    withStyle(style = SpanStyle(color = OrangePrimary)) {
                        append("Baru")
                    }
                    withStyle(style = SpanStyle(color = White)) {
                        append(".")
                    }
                }
            )
        },
        content = {
            AuthTextField(
                value = name,
                onValueChange = { name = it },
                label = "Full Name"
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))

            EmailTextField(
                value = email,
                onValueChange = { email = it }
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))

            PasswordTextField(
                value = password,
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingSmall))

            PasswordTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirm Password"
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

            PrimaryButton(
                text = "Register",
                onClick = onRegisterSuccess,
                modifier = Modifier
            )
        }
    )
}
