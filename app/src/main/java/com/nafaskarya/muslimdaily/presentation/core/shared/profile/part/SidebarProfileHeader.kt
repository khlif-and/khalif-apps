package com.nafaskarya.muslimdaily.presentation.core.shared.profile.part

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@Composable
fun SidebarProfileHeader(
    dimen: WindowDimensions,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = dimen.getResponsiveHeight(0.02f))
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFF7D583F),
            modifier = Modifier.size(dimen.width * 0.14f)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "K",
                    color = Color.White,
                    fontSize = dimen.getResponsiveTextSize(0.06f, min = 18f, max = 24f),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = "khalif",
                color = Color.White,
                fontSize = dimen.getResponsiveTextSize(0.05f, min = 16f, max = 20f),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "View profile",
                color = Color.Gray,
                fontSize = dimen.getResponsiveTextSize(0.035f, min = 12f, max = 14f)
            )
        }
    }
}