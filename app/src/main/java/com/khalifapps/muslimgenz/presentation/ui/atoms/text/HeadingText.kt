package com.khalifapps.muslimgenz.presentation.ui.atoms.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import com.khalifapps.muslimgenz.presentation.theme.White

/**
 * Large heading text - untuk judul utama halaman
 */
@Composable
fun HeadingLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Medium heading text - untuk sub-judul atau section title
 */
@Composable
fun HeadingMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Small heading text - untuk sub-section atau card title
 */
@Composable
fun HeadingSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Heading with AnnotatedString support - untuk styled text dengan multiple colors/styles
 */
@Composable
fun HeadingAnnotated(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun HeadingLargeAnnotated(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Composable
fun AuthHeadingAnnotated(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    val dimens = com.khalifapps.muslimgenz.presentation.theme.AppTheme.dimens
    Text(
        text = text,
        fontSize = dimens.textSizeTitle,
        lineHeight = dimens.lineHeightTitle,
        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
        textAlign = textAlign,
        modifier = modifier
    )
}
