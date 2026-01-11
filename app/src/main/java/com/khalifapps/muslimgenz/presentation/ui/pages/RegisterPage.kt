package com.khalifapps.muslimgenz.presentation.ui.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.ui.atoms.AuthOptionButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthFooter
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.templates.WelcomePageTemplate

@Composable
fun RegisterPage(
    onLoginClick: () -> Unit
) {
    WelcomePageTemplate(
        headerContent = {
            AuthHeader(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Yuk, Gabung\n")
                    }
                    withStyle(style = SpanStyle(color = OrangePrimary)) {
                        append("Sekarang")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append(".")
                    }
                }
            )
        },
        content = {
            AuthOptionButton(
                text = "Register With Email",
                icon = Icons.Default.Email,
                onClick = { /* TODO: Go to email register form */ }
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))
            
            AuthOptionButton(
                text = "Register With Phone",
                icon = Icons.Default.Call,
                onClick = { /* TODO: Go to phone register form */ }
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))
            
            AuthOptionButton(
                text = "Register With Google",
                icon = Icons.Default.AccountCircle, 
                onClick = { /* TODO: Google Auth */ },
                tint = OrangePrimary
            )
        },
        footerContent = {
            AuthFooter(
                normalText = "Already have account?",
                actionText = "Login Here",
                onClick = onLoginClick
            )
        }
    )
}
