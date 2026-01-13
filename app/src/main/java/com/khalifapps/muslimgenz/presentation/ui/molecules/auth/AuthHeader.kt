package com.khalifapps.muslimgenz.presentation.ui.molecules.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import com.khalifapps.muslimgenz.presentation.ui.atoms.text.AuthHeadingAnnotated

@Composable
fun AuthHeader(
    text: AnnotatedString
) {
    AuthHeadingAnnotated(text = text)
}
