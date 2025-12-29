package com.nafaskarya.muslimdaily.presentation.core.shared.profile.part

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@Composable
fun SidebarMenuItem(
    dimen: WindowDimensions,
    icon: ImageVector,
    label: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimen.getResponsiveHeight(0.02f))
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(dimen.width * 0.07f),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = dimen.getResponsiveTextSize(0.04f, min = 14f, max = 16f),
            fontWeight = FontWeight.Medium
        )
    }
}