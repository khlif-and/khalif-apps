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
 * Large title text - untuk app bar title atau prominent titles
 */
@Composable
fun TitleLarge(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = color,
        textAlign = textAlign,
        modifier = modifier
    )
}

/**
 * Medium title text - untuk card titles atau list headers
 */
@Composable
fun TitleMedium(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier
    )
}

/**
 * Small title text - untuk list item titles atau small headers
 */
@Composable
fun TitleSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = White,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        modifier = modifier
    )
}
