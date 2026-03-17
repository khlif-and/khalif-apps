package com.khalifapps.muslimgenz.presentation.ui.pages.TrendingNowDetailPages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TrendingNowDetailPage() {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("ALL") }

    val filters = listOf("ALL", "🔥 TRENDING", "REELS", "PODCAST")

    val libraryItems = listOf(
        LibraryItem(
            title = "Midnight Forest Echoes",
            category = "SPIRITUALITY",
            badgeText = "FEATURED",
            badgeColor = Color(0xFFD4AF37),
            views = "24k",
            rating = "4.9",
            height = 280.dp,
            type = LibraryItemType.AUDIO,
            backgroundColor = Color(0xFF1E3A5F)
        ),
        LibraryItem(
            title = "Stellar Voyage",
            listeners = "156 Live Listeners",
            height = 200.dp,
            type = LibraryItemType.LIVE,
            backgroundColor = Color(0xFF1B1B22)
        ),
        LibraryItem(
            title = "Deep Ocean Breath",
            badgeText = "TRENDING",
            badgeColor = Color(0xFF40E0D0),
            reads = "8.2K READS",
            duration = "12 MIN",
            height = 220.dp,
            type = LibraryItemType.READING,
            backgroundColor = Color(0xFF2E8B57)
        ),
        LibraryItem(
            title = "Urban Calm Secrets",
            category = "ARTICLE",
            height = 200.dp,
            type = LibraryItemType.ARTICLE,
            backgroundColor = Color(0xFF2C1E16)
        ),
        LibraryItem(
            title = "Morning Peak Clarity",
            badgeText = "MOTIVATION",
            badgeColor = Color(0xFFB8860B),
            energyLevel = "High Energy",
            height = 260.dp,
            type = LibraryItemType.ENERGY,
            backgroundColor = Color(0xFF8B4513)
        ),
        LibraryItem(
            title = "Zen Forest Bathe",
            joined = "+30k joined",
            height = 280.dp,
            type = LibraryItemType.COMMUNITY,
            backgroundColor = Color(0xFF3B5323)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D1522))
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF162032))
                    .border(1.dp, Color(0xFF2A3647), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Library",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "64 MASTERPIECES FOUND",
                    color = Color(0xFFB5935A),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF162032))
                    .border(1.dp, Color(0xFF2A3647), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Filter",
                        tint = Color.White
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF111926))
                    .border(1.dp, Color(0xFF2A3647), CircleShape)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(0xFFEAB308)
                )
                Spacer(modifier = Modifier.width(12.dp))
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    ),
                    cursorBrush = SolidColor(Color.White),
                    decorationBox = { innerTextField ->
                        if (searchQuery.isEmpty()) {
                            Text(
                                text = "Search atmospheres...",
                                color = Color(0xFF6B7280),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF111926))
                    .border(1.dp, Color(0xFF2A3647), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = null,
                        tint = Color(0xFFEAB308)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filters) { filter ->
                val isSelected = filter == selectedFilter
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .clip(CircleShape)
                        .background(if (isSelected) Color(0xFFEAB308) else Color(0xFF162032))
                        .border(
                            width = 1.dp,
                            color = if (isSelected) Color.Transparent else Color(0xFF2A3647),
                            shape = CircleShape
                        )
                        .clickable { selectedFilter = filter }
                        .padding(horizontal = 20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = filter,
                        color = if (isSelected) Color(0xFF0D1522) else Color(0xFF9CA3AF),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp,
            modifier = Modifier.fillMaxSize()
        ) {
            items(libraryItems) { item ->
                LibraryCard(item = item)
            }
        }
    }
}

@Composable
fun LibraryCard(item: LibraryItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(item.height)
            .clip(RoundedCornerShape(24.dp))
            .background(item.backgroundColor)
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(24.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        ),
                        startY = 100f
                    )
                )
        )

        if (item.badgeText != null) {
            Box(
                modifier = Modifier
                    .align(if (item.type == LibraryItemType.READING) Alignment.TopEnd else Alignment.TopStart)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(item.badgeColor ?: Color.Gray)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = item.badgeText,
                    color = if (item.badgeColor == Color(0xFF40E0D0)) Color.Black else Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.5.sp
                )
            }
        }

        if (item.type == LibraryItemType.ARTICLE) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = null,
                    tint = Color(0xFFD4AF37),
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.category ?: "",
                    color = Color.LightGray,
                    fontSize = 10.sp,
                    letterSpacing = 1.sp
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                if (item.category != null && item.type != LibraryItemType.ARTICLE) {
                    Text(
                        text = item.category,
                        color = Color(0xFF40E0D0),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }

                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    when (item.type) {
                        LibraryItemType.AUDIO -> {
                            Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(12.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = item.views ?: "", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(12.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = item.rating ?: "", color = Color.Gray, fontSize = 12.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFD4AF37)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black, modifier = Modifier.size(20.dp))
                            }
                        }
                        LibraryItemType.LIVE -> {
                            Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF40E0D0)))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = item.listeners ?: "", color = Color.LightGray, fontSize = 10.sp)
                        }
                        LibraryItemType.READING -> {
                            Text(text = item.reads ?: "", color = Color.Gray, fontSize = 10.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(Color(0xFF40E0D0)))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = item.duration ?: "", color = Color(0xFF40E0D0), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                        LibraryItemType.ENERGY -> {
                            Icon(Icons.Default.Bolt, contentDescription = null, tint = Color(0xFF40E0D0), modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = item.energyLevel ?: "", color = Color.Gray, fontSize = 12.sp)
                        }
                        LibraryItemType.COMMUNITY -> {
                            Row {
                                Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(Color.Gray))
                                Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(Color.DarkGray))
                                Box(modifier = Modifier.size(24.dp).clip(CircleShape).background(Color.LightGray))
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = item.joined ?: "", color = Color.LightGray, fontSize = 10.sp)
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}

enum class LibraryItemType {
    AUDIO, LIVE, READING, ARTICLE, ENERGY, COMMUNITY
}

data class LibraryItem(
    val title: String,
    val category: String? = null,
    val badgeText: String? = null,
    val badgeColor: Color? = null,
    val views: String? = null,
    val rating: String? = null,
    val listeners: String? = null,
    val reads: String? = null,
    val duration: String? = null,
    val energyLevel: String? = null,
    val joined: String? = null,
    val height: Dp,
    val type: LibraryItemType,
    val backgroundColor: Color
)