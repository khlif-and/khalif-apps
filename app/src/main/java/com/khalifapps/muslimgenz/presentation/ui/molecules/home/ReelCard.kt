package com.khalifapps.muslimgenz.presentation.ui.molecules.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun ReelCard(
    title: String,
    views: String,
    imageRes: Int
) {
    val dimens = AppTheme.dimens
    Box(
        modifier = Modifier
            .width(dimens.reelCardWidth)
            .height(dimens.reelCardHeight)
            .clip(RoundedCornerShape(dimens.radiusLarge))
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .padding(dimens.spacingSmall)
                .size(dimens.playOverlaySize)
                .clip(CircleShape)
                .background(White)
                .align(Alignment.TopEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = PlayIconDark,
                modifier = Modifier.size(dimens.iconSizeSmall)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.paddingSmall)
                .clip(RoundedCornerShape(dimens.radiusMedium))
                .background(CardInfoOverlay.copy(alpha = 0.85f))
                .align(Alignment.BottomCenter)
                .padding(horizontal = dimens.spacingSmall, vertical = dimens.textSizeEmojiXSmall.value.toInt().let { dimens.paddingSmall })
        ) {
            Column {
                Text(
                    text = title,
                    color = White,
                    fontSize = dimens.textSizeBody,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(dimens.paddingSmall / 2))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "👁️",
                        fontSize = dimens.textSizeEmojiXSmall,
                        color = GoldPrimary
                    )
                    Spacer(modifier = Modifier.width(dimens.paddingSmall / 2))
                    Text(
                        text = views,
                        color = White.copy(alpha = 0.7f),
                        fontSize = dimens.textSizeReelInfo
                    )
                }
            }
        }
    }
}
