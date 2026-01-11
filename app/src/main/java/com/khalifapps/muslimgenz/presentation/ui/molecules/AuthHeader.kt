package com.khalifapps.muslimgenz.presentation.ui.molecules

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.presentation.theme.AppTheme

@Composable
fun AuthHeader(
    text: AnnotatedString
) {
    Text(
        text = text,
        fontSize = AppTheme.dimens.textSizeTitle,
        lineHeight = AppTheme.dimens.lineHeightTitle,
        fontWeight = FontWeight.Bold
    )
}
