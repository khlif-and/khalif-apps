package com.khalifapps.muslimgenz.presentation.ui.atoms.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.khalifapps.muslimgenz.presentation.theme.White

/**
 * Large label text - untuk button text atau prominent labels
 */
@Composable
fun LabelLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelLarge,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Medium label text - untuk form labels atau chip text
 */
@Composable
fun LabelMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Small label text - untuk caption atau helper text
 */
@Composable
fun LabelSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}
