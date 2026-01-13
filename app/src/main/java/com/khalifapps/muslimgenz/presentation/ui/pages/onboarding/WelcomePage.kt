package com.khalifapps.muslimgenz.presentation.ui.pages.onboarding

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.AuthOptionButton
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthFooter
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.templates.WelcomePageTemplate

@Composable
fun WelcomePage(
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit,
    onLoginPhoneClick: () -> Unit
) {
    WelcomePageTemplate(
        headerContent = {
            AuthHeader(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = White)) {
                        append("Yuk, Mulai ")
                    }
                    withStyle(style = SpanStyle(color = OrangePrimary)) {
                        append("Berubah")
                    }
                    withStyle(style = SpanStyle(color = White)) {
                        append(".\nMulai ")
                    }
                    withStyle(style = SpanStyle(color = OrangePrimary)) {
                        append("Berarah")
                    }
                    withStyle(style = SpanStyle(color = White)) {
                        append(".")
                    }
                }
            )
        },
        content = {
            AuthOptionButton(
                text = "Login With Email",
                icon = Icons.Default.Email,
                onClick = onLoginClick
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))
            
            AuthOptionButton(
                text = "Login With Phone",
                icon = Icons.Default.Call,
                onClick = onLoginPhoneClick
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))
            
            AuthOptionButton(
                text = "Login With Google",
                icon = Icons.Default.AccountCircle, 
                onClick = { /* TODO */ },
                tint = OrangePrimary
            )
        },
        footerContent = {
            AuthFooter(
                normalText = "Don't have account khalif?",
                actionText = "Register Here",
                onClick = onRegisterClick
            )
        }
    )
}
