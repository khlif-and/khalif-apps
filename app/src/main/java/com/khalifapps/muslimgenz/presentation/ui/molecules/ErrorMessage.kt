package com.khalifapps.muslimgenz.presentation.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PriorityHigh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.presentation.theme.FormBackground
import com.khalifapps.muslimgenz.presentation.theme.LocalAppDimens
import com.khalifapps.muslimgenz.presentation.theme.White

@Composable
fun ErrorMessage(
    message: String,
    modifier: Modifier = Modifier
) {
    val dimens = LocalAppDimens.current
    
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimens.radiusSmall))
            .background(FormBackground)
            .padding(dimens.paddingMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Container (White Circle)
        Box(
            modifier = Modifier
                .size(dimens.iconSize)
                .clip(CircleShape)
                .background(White),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PriorityHigh,
                contentDescription = "Error",
                tint = FormBackground, // Use dark color for the icon symbol itself to contrast with White circle
                modifier = Modifier.size(dimens.iconSizeSmall)
            )
        }

        Spacer(modifier = Modifier.width(dimens.spacingSmall))

        Text(
            text = message,
            color = White,
            fontSize = dimens.textSizeBody,
            fontWeight = FontWeight.Normal
        )
    }
}
