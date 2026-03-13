package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.R
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun GreetingCard() {
    val dimens = AppTheme.dimens
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.greetingCardHeight)
            .clip(RoundedCornerShape(dimens.radiusXLarge))
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_mosque),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimens.glassInnerPaddingH, vertical = dimens.glassInnerPaddingV)
                .clip(RoundedCornerShape(dimens.radiusLarge))
                .background(GlassWhite)
                .align(Alignment.BottomCenter)
                .padding(dimens.glassPadding)
        ) {
            Column {
                Text(
                    text = HomeStrings.GREETING_TITLE,
                    color = White,
                    fontSize = dimens.textSizeSection,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(dimens.paddingSmall))
                Text(
                    text = HomeStrings.GREETING_SUBTITLE,
                    color = White.copy(alpha = 0.8f),
                    fontSize = dimens.textSizeBody
                )
            }
        }
    }
}
