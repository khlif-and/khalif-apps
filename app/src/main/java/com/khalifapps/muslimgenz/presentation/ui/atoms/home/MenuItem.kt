package com.khalifapps.muslimgenz.presentation.ui.atoms.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.GoldPrimary
import com.khalifapps.muslimgenz.presentation.theme.White

@Composable
fun MenuItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit = {}
) {
    val dimens = AppTheme.dimens
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(dimens.menuItemWidth)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(dimens.menuItemIconSize)
                .clip(RoundedCornerShape(dimens.radiusLarge))
                .background(GoldPrimary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = White,
                modifier = Modifier.size(dimens.menuInnerIconSize)
            )
        }
        Spacer(modifier = Modifier.height(dimens.paddingSmall))
        Text(
            text = label,
            color = White,
            fontSize = dimens.textSizeSmall,
            fontWeight = FontWeight.Medium
        )
    }
}