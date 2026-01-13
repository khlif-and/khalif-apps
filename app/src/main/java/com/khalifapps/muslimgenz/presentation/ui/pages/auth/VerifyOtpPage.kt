package com.khalifapps.muslimgenz.presentation.ui.pages.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthFooter
import com.khalifapps.muslimgenz.presentation.ui.molecules.auth.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.molecules.inputs.OtpTextField
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate
import com.khalifapps.muslimgenz.presentation.ui.pages.common.LoaderPage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun VerifyOtpPage(
    onVerifyClick: () -> Unit,
    onResendClick: () -> Unit
) {
    var otpValue by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        if (!isLoading) {
            focusRequester.requestFocus()
            keyboardController?.show()
        }
    }

    if (isLoading) {
        LoaderPage()
    } else {
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
                    onClick = {
                        isLoading = true
                        scope.launch {
                            delay(2000)
                            isLoading = false
                            onVerifyClick()
                        }
                    },
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
}
