package com.nafaskarya.muslimdaily.presentation.core.components.menuSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.NewReleases
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant

@Composable
fun MenuSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ColorConstant.BackgroundDark)
            .padding(16.dp)
    ) {
        Text(
            text = "Explore",
            style = MaterialTheme.typography.headlineSmall,
            color = ColorConstant.TextWhite,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ExploreCard(
                icon = Icons.Outlined.NewReleases,
                label = "New\nreleases",
                modifier = Modifier.weight(1f)
            )
            ExploreCard(
                icon = Icons.AutoMirrored.Filled.TrendingUp,
                label = "Charts",
                modifier = Modifier.weight(1f)
            )
            ExploreCard(
                icon = Icons.Outlined.EmojiEmotions,
                label = "Moods &\ngenres",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ExploreCard(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(
                color = ColorConstant.ProfileSurface,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = ColorConstant.TextWhite,
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.TopStart)
        )

        Text(
            text = label,
            color = ColorConstant.TextWhite,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 18.sp,
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}