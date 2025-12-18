package com.nafaskarya.muslimdaily.presentation.core.components.sampleSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WifiTethering
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant

data class SampleItem(
    val title: String,
    val artist: String,
    val imageUrl: String,
    val hasProgress: Boolean = false
)

@Composable
fun SampleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(ColorConstant.BackgroundDark)
            .padding(16.dp)
    ) {
        ShortsHeaderCard()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Samples for you",
            color = ColorConstant.TextWhite,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        val samples = listOf(
            SampleItem("I Lost a Friend", "FINNEAS", ""),
            SampleItem("Safe, Now - Ambient...", "Harris Cole..", ""),
            SampleItem("Maulana", "Opick", "", true),
            SampleItem("Queen", "AL...", "")
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(samples) { item ->
                SampleCard(item)
            }
        }
    }
}

@Composable
fun ShortsHeaderCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2D1614)), // Warna khusus header
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(Color(0xFFFF4B4B), Color(0xFFFFB6C1))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text("S", color = ColorConstant.TextWhite, fontSize = 40.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Sounds from Shorts",
                        color = ColorConstant.TextWhite,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "arthaloka radenningrat",
                        color = ColorConstant.TextGray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "1 song",
                        color = ColorConstant.TextGray,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(ColorConstant.SurfaceDark)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "United In Grief",
                        color = ColorConstant.TextWhite,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = RoundedCornerShape(2.dp),
                            color = ColorConstant.TextGray,
                            modifier = Modifier.size(14.dp)
                        ) {
                            Text(
                                "E",
                                fontSize = 10.sp,
                                color = ColorConstant.BackgroundDark,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.wrapContentSize(Alignment.Center)
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Kendrick Lamar • 66M pla...",
                            color = ColorConstant.TextGray,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = ColorConstant.TextWhite
                )
            }

            Row(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Surface(
                    shape = CircleShape,
                    color = ColorConstant.TextWhite.copy(alpha = 0.2f),
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = ColorConstant.TextWhite,
                        modifier = Modifier.padding(12.dp)
                    )
                }

                Surface(
                    shape = CircleShape,
                    border = androidx.compose.foundation.BorderStroke(1.dp, ColorConstant.TextWhite.copy(alpha = 0.3f)),
                    color = Color.Transparent,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.WifiTethering,
                        contentDescription = null,
                        tint = ColorConstant.TextWhite,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SampleCard(item: SampleItem) {
    Column(
        modifier = Modifier.width(140.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(ColorConstant.SurfaceDark)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = item.title,
                    color = ColorConstant.TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    maxLines = 2,
                    lineHeight = 18.sp
                )
                Text(
                    text = item.artist,
                    color = ColorConstant.TextGray,
                    fontSize = 12.sp
                )
            }

            if (item.hasProgress) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color.Magenta.copy(alpha = 0.8f))
                )
            }
        }
    }
}