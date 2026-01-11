package com.khalifapps.muslimgenz.presentation.ui.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.InputTextField
import com.khalifapps.muslimgenz.presentation.ui.atoms.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate

@Composable
fun LoginEmailPage(
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

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
            // Inputs
            InputTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                shape = RectangleShape
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            InputTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        androidx.compose.material.icons.Icons.Filled.Visibility
                    else
                        androidx.compose.material.icons.Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null, tint = Color.Gray)
                    }
                },
                shape = RectangleShape
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))
            
            PrimaryButton(
                text = "Login",
                onClick = onLoginSuccess,
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(AppTheme.dimens.buttonHeightPill)
            )
        }
    )
}
