package com.khalifapps.muslimgenz.presentation.ui.molecules.result

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.khalifapps.muslimgenz.presentation.theme.AppBackground
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White

@Composable
fun AvatarStack(
    modifier: Modifier = Modifier,
    avatarSize: Dp = 60.dp,
    overlap: Dp = 20.dp
) {
    // Dummy Data for now as per image: Light Gray, Redish, Greenish, Dark (+5)
    // In real app this would take a list of image URLs/Colors
    val colors = listOf(Color.LightGray, Color(0xFFE57373), Color(0xFF81C784))
    
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            colors.forEachIndexed { index, color ->
                Box(
                    modifier = Modifier
                        .size(avatarSize)
                        .offset(x = (-overlap * index))
                        .zIndex(index.toFloat())
                        .clip(CircleShape)
                        .background(color)
                        .border(2.dp, AppBackground, CircleShape)
                )
            }
            
            // The "+5" indicator
            Box(
                modifier = Modifier
                    .size(avatarSize)
                    .offset(x = (-overlap * colors.size))
                    .zIndex(colors.size.toFloat())
                    .clip(CircleShape)
                    .background(Color(0xFF1E1E1E)) // Dark Gray
                    .border(2.dp, AppBackground, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+5",
                    color = White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
