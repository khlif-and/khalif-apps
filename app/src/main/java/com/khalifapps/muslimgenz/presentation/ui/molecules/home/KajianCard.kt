package com.khalifapps.muslimgenz.presentation.ui.molecules.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import com.khalifapps.muslimgenz.R
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun KajianCard() {
    val dimens = AppTheme.dimens
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimens.radiusXLarge))
            .background(CardDarkVariant)
            .padding(dimens.paddingMedium)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_ustadz),
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimens.avatarSmall)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(dimens.spacingSmall))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = HomeStrings.KAJIAN_TITLE,
                        color = White,
                        fontSize = dimens.textSizeBody,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(dimens.paddingSmall / 2))
                    Text(
                        text = HomeStrings.KAJIAN_AUTHOR,
                        color = IconMuted,
                        fontSize = dimens.textSizeEmojiXSmall,
                        letterSpacing = dimens.letterSpacingWide
                    )
                }

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More options",
                    tint = IconMuted,
                    modifier = Modifier.size(dimens.iconSize)
                )
            }

            Spacer(modifier = Modifier.height(dimens.paddingMedium))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimens.kajianVideoHeight)
                    .clip(RoundedCornerShape(dimens.radiusLarge))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bg_kajian_ustadz),
                    contentDescription = "Video Thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .size(dimens.playButtonSize)
                        .clip(CircleShape)
                        .background(GoldPrimary)
                        .align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Video",
                        tint = PlayIconDark,
                        modifier = Modifier.size(dimens.iconSizeXLarge)
                    )
                }
            }
        }
    }
}
