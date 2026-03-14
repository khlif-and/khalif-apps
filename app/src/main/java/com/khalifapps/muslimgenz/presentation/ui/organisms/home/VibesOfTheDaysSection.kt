package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class untuk menampung info Vibe
data class VibeItem(
    val title: String,
    val listeners: String,
    val gradientColors: List<Color>
)

@Composable
fun VibesOfTheDaysSection(
    modifier: Modifier = Modifier,
    onPlaylistClick: () -> Unit
) {
    val dummyVibes = listOf(
        VibeItem(
            title = "Morning Dhikr\nLo-fi",
            listeners = "324 listeners",
            gradientColors = listOf(
                Color(0xFF4A55A2), // Warna Biru
                Color(0xFF3AC4B2)  // Warna Teal/Cyan
            )
        ),
        VibeItem(
            title = "Focus\nQuran",
            listeners = "1.2k listeners",
            gradientColors = listOf(
                Color(0xFF2E7D32), // Warna Hijau tua
                Color(0xFF9CCC65)  // Warna Hijau muda/kekuningan
            )
        )
    )

    Column(modifier = modifier.fillMaxWidth()) {
        // Bagian Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Vibe of the Day",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Menggunakan icon bawaan Android sebagai placeholder untuk Note Musik
            Icon(
                painter = painterResource(id = android.R.drawable.ic_media_play), // Ganti dengan Icon Music Note aslimu
                contentDescription = "Music Note",
                tint = Color(0xFF3AC4B2),
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bagian List Horizontal (Scrollable)
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(dummyVibes) { vibe ->
                VibeCard(vibe = vibe, onClick = onPlaylistClick)
            }
        }
    }
}

@Composable
fun VibeCard(vibe: VibeItem, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(210.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(Brush.linearGradient(colors = vibe.gradientColors))
            .clickable { onClick() }
            .padding(20.dp)
    ) {
        // Judul di Kiri Atas
        Text(
            text = vibe.title,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            modifier = Modifier.align(Alignment.TopStart).fillMaxWidth(0.8f)
        )

        // Icon Speaker di Kanan Atas
        Icon(
            painter = painterResource(id = android.R.drawable.ic_lock_silent_mode_off), // Ganti dengan Icon Speaker aslimu
            contentDescription = "Speaker",
            tint = Color(0x99FFFFFF), // Putih transparan
            modifier = Modifier.align(Alignment.TopEnd).size(20.dp)
        )

        // Teks Listeners di Kiri Bawah
        Text(
            text = vibe.listeners,
            color = Color(0xCCFFFFFF), // Putih sedikit pudar
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.BottomStart)
        )

        // Tombol Play di Kanan Bawah
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(44.dp)
                .clip(CircleShape)
                .background(Color(0x33FFFFFF)), // Putih sangat transparan (glass effect)
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}