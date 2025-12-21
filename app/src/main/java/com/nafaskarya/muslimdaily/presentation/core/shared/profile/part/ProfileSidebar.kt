package com.nafaskarya.muslimdaily.presentation.core.shared.profile.part

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@Composable
fun ProfileSidebar(
    modifier: Modifier = Modifier
) {
    val dimen = rememberWindowDimensions()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.06f)))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = dimen.getResponsiveHeight(0.02f))
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

@Composable
private fun SidebarMenuItem(
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