package com.khalifapps.muslimgenz.presentation.ui.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthFooter
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.molecules.OtpTextField
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate

import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun VerifyOtpPage(
    onVerifyClick: () -> Unit,
    onResendClick: () -> Unit
) {
    var otpValue by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    AuthPageTemplate(
        headerContent = {
            AuthHeader(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = White)) {
                        append("Masukan OTP yang\nsudah kami kirimkan.")
                    }
                }
            )
        },
        content = {
            OtpTextField(
                value = otpValue,
                onValueChange = { otpValue = it },
                modifier = Modifier.focusRequester(focusRequester)
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

            PrimaryButton(
                text = "Verify",
                onClick = onVerifyClick,
                modifier = Modifier
            )
            
            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

            AuthFooter(
                normalText = "Didn't receive the OTP?",
                actionText = "Resend",
                onClick = onResendClick
            )
        }
    )
}
