package com.khalifapps.muslimgenz.presentation.ui.atoms.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.presentation.theme.FormBackground
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.theme.AppTheme

@Composable
fun AuthOptionButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    tint: Color = White
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppTheme.dimens.cornerRadiusPill))
            .background(FormBackground)
            .clickable { onClick() }
            .padding(vertical = AppTheme.dimens.buttonPaddingVertical, horizontal = AppTheme.dimens.paddingLarge),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(AppTheme.dimens.iconSizeLarge)
        )
        Spacer(modifier = Modifier.width(AppTheme.dimens.paddingMedium))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = White,
                fontSize = AppTheme.dimens.textSizeButton,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.width(AppTheme.dimens.paddingLarge)) 
    }
}
