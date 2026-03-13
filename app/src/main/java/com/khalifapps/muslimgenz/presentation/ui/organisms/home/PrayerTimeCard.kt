package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun PrayerTimeCard() {
    val dimens = AppTheme.dimens
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimens.radiusXLarge))
            .background(MaterialTheme.colorScheme.surface)
            .padding(dimens.glassPadding)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(dimens.prayerIconSize)
                            .clip(RoundedCornerShape(dimens.radiusSmall))
                            .background(GoldDark),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🕒", fontSize = dimens.textSizeEmojiSmall)
                    }
                    Spacer(modifier = Modifier.width(dimens.spacingSmall))
                    Text(
                        text = HomeStrings.PRAYER_NAME,
                        color = White,
                        fontSize = dimens.textSizeMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = HomeStrings.PRAYER_COUNTDOWN,
                        color = GoldPrimary,
                        fontSize = dimens.textSizeButton
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimens.radiusMedium))
                        .background(GlassWhiteSubtle)
                        .padding(horizontal = dimens.spacingSmall, vertical = dimens.paddingSmall)
                ) {
                    Text(
                        text = HomeStrings.PRAYER_NEXT,
                        color = GoldPrimary,
                        fontSize = dimens.textSizeSmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(dimens.paddingMedium))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimens.progressBarHeight)
                    .clip(RoundedCornerShape(dimens.progressBarHeight / 2))
                    .background(ProgressTrack)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(dimens.progressBarHeight / 2))
                        .background(GoldLight)
                )
            }
        }
    }
}
