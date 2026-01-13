package com.khalifapps.muslimgenz.presentation.ui.pages.result

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.graphics.Color
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.text.BodyMedium
import com.khalifapps.muslimgenz.presentation.ui.atoms.text.HeadingAnnotated
import com.khalifapps.muslimgenz.presentation.ui.molecules.result.AvatarStack
import com.khalifapps.muslimgenz.presentation.ui.templates.ResultPageTemplate
import kotlinx.coroutines.delay

@Composable
fun ResultPage(
    onFinished: () -> Unit
) {
    // Auto navigate after 3 seconds (simulating loading/setup)
    LaunchedEffect(Unit) {
        delay(3000)
        onFinished()
    }

    ResultPageTemplate {
        AvatarStack()

        Spacer(modifier = Modifier.height(AppTheme.dimens.paddingHuge))

        HeadingAnnotated(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = White)) {
                    append("Pilihan Kamu\n")
                }
                withStyle(style = SpanStyle(color = White)) { // Image shows all white bold
                    append("Masyallah Banget loh")
                }
            },
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

        // "memuat pilihanmu..." - slightly lighter/smaller
        BodyMedium(
            text = "memuat pilihanmu...",
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}
