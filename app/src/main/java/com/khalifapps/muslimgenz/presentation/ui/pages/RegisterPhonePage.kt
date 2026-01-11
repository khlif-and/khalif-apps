package com.khalifapps.muslimgenz.presentation.ui.pages

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.molecules.AuthHeader
import com.khalifapps.muslimgenz.presentation.ui.molecules.PhoneTextField
import com.khalifapps.muslimgenz.presentation.ui.templates.AuthPageTemplate

@Composable
fun RegisterPhonePage(
    onRegisterSuccess: () -> Unit
) {
    var phoneNumber by remember { mutableStateOf("") }

    AuthPageTemplate(
        headerContent = {
            AuthHeader(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = White)) {
                        append("Register Dengan Nomor HandPhone.")
                    }
                }
            )
        },
        content = {
            PhoneTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it }
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
