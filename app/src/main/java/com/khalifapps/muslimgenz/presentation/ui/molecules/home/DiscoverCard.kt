package com.khalifapps.muslimgenz.presentation.ui.molecules.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun DiscoverCard(
    title: String,
    subtitle: String,
    imageRes: Int
) {
    val dimens = AppTheme.dimens
    Column(
        modifier = Modifier.width(dimens.discoverCardWidth)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(dimens.radiusLarge))
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        
        Spacer(modifier = Modifier.height(dimens.paddingSmall))
        
        Text(
            text = title,
            color = White,
            fontSize = dimens.textSizeButton,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        
        Spacer(modifier = Modifier.height(dimens.paddingSmall / 2))
        
        Text(
            text = subtitle,
            color = IconMuted,
            fontSize = dimens.textSizeSmall,
            lineHeight = dimens.textSizeBody,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
