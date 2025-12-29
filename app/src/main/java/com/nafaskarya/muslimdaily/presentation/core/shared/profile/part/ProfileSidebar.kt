package com.nafaskarya.muslimdaily.presentation.core.shared.profile.part

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.state.LocalGuestScreenState
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@Composable
fun ProfileSidebar() {
    val state = LocalGuestScreenState.current
    val dimen = rememberWindowDimensions()

    if (state.showSidebar) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { state.toggleSidebar() }
        )
    }

    AnimatedVisibility(
        visible = state.showSidebar,
        enter = slideInHorizontally(initialOffsetX = { -it }),
        exit = slideOutHorizontally(targetOffsetX = { -it })
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .graphicsLayer {
                    clip = true
                    renderEffect = null
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF121212))
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.06f)))

                SidebarProfileHeader(dimen = dimen)

                HorizontalDivider(color = Color.DarkGray, thickness = 0.5.dp)

                SidebarMenuItem(dimen, Icons.Default.Add, "Add account")
                SidebarMenuItem(dimen, Icons.Default.ElectricBolt, "What's new")
                SidebarMenuItem(dimen, Icons.Outlined.History, "Recents")
                SidebarMenuItem(dimen, Icons.Outlined.Settings, "Settings and privacy")

                HorizontalDivider(
                    color = Color.DarkGray,
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = "Messages",
                    color = Color.White,
                    fontSize = dimen.getResponsiveTextSize(0.055f, min = 18f, max = 22f),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = dimen.getResponsiveHeight(0.015f))
                )

                Text(
                    text = "Share what you love with friends, right on Muslim Daily.",
                    color = Color.Gray,
                    fontSize = dimen.getResponsiveTextSize(0.035f, min = 12f, max = 14f),
                    modifier = Modifier.padding(bottom = dimen.getResponsiveHeight(0.025f))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF282828),
                        modifier = Modifier.size(dimen.width * 0.12f)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = null,
                                modifier = Modifier.size(dimen.width * 0.06f),
                                tint = Color.White
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "New message",
                        color = Color.White,
                        fontSize = dimen.getResponsiveTextSize(0.04f, min = 14f, max = 16f),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}