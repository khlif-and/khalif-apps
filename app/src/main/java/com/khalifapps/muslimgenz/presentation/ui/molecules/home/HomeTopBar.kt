package com.khalifapps.muslimgenz.presentation.ui.molecules.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.presentation.theme.*

@Composable
fun HomeTopBar(onSearchClick: () -> Unit) {
    val dimens = AppTheme.dimens
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(dimens.topBarIconSize)
                .clip(CircleShape)
                .background(Color(0xFFEAB308)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "K",
                color = Color(0xFF0D1522),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(dimens.paddingMedium))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = HomeStrings.ISLAMIC_DATE,
                color = White,
                fontSize = dimens.textSizeButton,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = HomeStrings.GREGORIAN_DATE,
                color = IconMuted,
                fontSize = dimens.textSizeBody
            )
        }
        IconButton(onClick = onSearchClick) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = White
            )
        }
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = White
            )
        }
    }
}