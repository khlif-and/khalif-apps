package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.presentation.theme.AppTheme

@Composable
fun NewsUpdatedSection(
    modifier: Modifier = Modifier,
    newsText: String = "LIVE UMMAH UPDATE: COMMUNITY RELIEF EFFORT..."
) {
    val dimens = AppTheme.dimens

    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF4A4231),
                shape = CircleShape
            )
            .background(
                color = Color(0xFF1A2228),
                shape = CircleShape
            )
            .padding(horizontal = dimens.paddingMedium, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(5.dp)
                .height(14.dp)
                .clip(CircleShape)
                .background(Color(0xFF3AC4B2))
        )

        Spacer(modifier = Modifier.width(dimens.paddingSmall))

        Text(
            text = newsText.uppercase(),
            color = Color(0xFF3AC4B2),
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}