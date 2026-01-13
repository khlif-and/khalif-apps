package com.khalifapps.muslimgenz.presentation.ui.atoms.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.khalifapps.muslimgenz.presentation.theme.White

/**
 * Large body text - untuk paragraph utama
 */
@Composable
fun BodyLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier
    )
}

/**
 * Medium body text - untuk body text standar
 */
@Composable
fun BodyMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier
    )
}

/**
 * Small body text - untuk secondary text atau descriptions
 */
@Composable
fun BodySmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier
    )
}
