package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun AyahOfTheDayCard() {
    val dimens = AppTheme.dimens
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimens.radiusXLarge))
            .background(CardDark)
            .padding(dimens.paddingLarge)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = HomeStrings.AYAH_HEADER,
                    color = GoldPrimary,
                    fontSize = dimens.textSizeSmall,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = dimens.letterSpacingWide
                )
                Icon(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = "Quote",
                    tint = GoldPrimary,
                    modifier = Modifier.size(dimens.iconSize)
                )
            }

            Spacer(modifier = Modifier.height(dimens.paddingLarge))

            Text(
                text = HomeStrings.AYAH_ARABIC,
                color = White,
                fontSize = dimens.textSizeArabic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Right
            )

            Spacer(modifier = Modifier.height(dimens.paddingLarge))

            Text(
                text = HomeStrings.AYAH_TRANSLATION,
                color = White,
                fontSize = dimens.textSizeMedium,
                lineHeight = dimens.lineHeightBody
            )

            Spacer(modifier = Modifier.height(dimens.paddingSmall))

            Text(
                text = HomeStrings.AYAH_SOURCE,
                color = GoldPrimary,
                fontSize = dimens.textSizeBody,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(dimens.paddingExtraLarge))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(dimens.paddingMedium)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Like",
                        tint = IconMuted,
                        modifier = Modifier.size(dimens.iconSizeLarge)
                    )
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        tint = IconMuted,
                        modifier = Modifier.size(dimens.iconSizeLarge)
                    )
                }

                Box(
                    modifier = Modifier
                        .size(dimens.playButtonSize)
                        .clip(CircleShape)
                        .background(GoldPrimary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Audio",
                        tint = CardDark,
                        modifier = Modifier.size(dimens.iconSizeXLarge)
                    )
                }
            }
        }
    }
}
