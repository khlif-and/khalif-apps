package com.khalifapps.muslimgenz.presentation.ui.pages.CalendarPages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalenderPage() {
    val tabItems = listOf("Month", "Week")
    var selectedIndex by remember { mutableIntStateOf(0) }

    val daysOfWeek = listOf("SU", "MO", "TU", "WE", "TH", "FR", "SA")

    val calendarDays = listOf(
        CalendarDayData("", "", isCurrentMonth = false),
        CalendarDayData("", "", isCurrentMonth = false),
        CalendarDayData("1", "٧", isCurrentMonth = true),
        CalendarDayData("2", "٨", isCurrentMonth = true),
        CalendarDayData("3", "٩", isCurrentMonth = true),
        CalendarDayData("4", "١٠", isCurrentMonth = true),
        CalendarDayData("5", "١١", isCurrentMonth = true),
        CalendarDayData("6", "١٢", isCurrentMonth = true),
        CalendarDayData("7", "١٣", isCurrentMonth = true, hasEvent = true),
        CalendarDayData("8", "١٤", isCurrentMonth = true),
        CalendarDayData("9", "١٥", isCurrentMonth = true),
        CalendarDayData("10", "١٦", isCurrentMonth = true),
        CalendarDayData("11", "١٧", isCurrentMonth = true),
        CalendarDayData("12", "١٨", isCurrentMonth = true),
        CalendarDayData("13", "١٩", isCurrentMonth = true),
        CalendarDayData("14", "٢٠", isCurrentMonth = true),
        CalendarDayData("15", "٢١", isCurrentMonth = true),
        CalendarDayData("16", "٢٢", isCurrentMonth = true),
        CalendarDayData("17", "٢٣", isCurrentMonth = true),
        CalendarDayData("18", "٢٤", isCurrentMonth = true),
        CalendarDayData("19", "٢٥", isCurrentMonth = true),
        CalendarDayData("20", "٢٦", isCurrentMonth = true),
        CalendarDayData("21", "٢٧", isCurrentMonth = true),
        CalendarDayData("22", "٢٨", isCurrentMonth = true),
        CalendarDayData("23", "٢٩", isCurrentMonth = true),
        CalendarDayData("24", "٣٠", isCurrentMonth = true, isSelected = true),
        CalendarDayData("25", "١", isCurrentMonth = false),
        CalendarDayData("26", "٢", isCurrentMonth = false),
        CalendarDayData("27", "٣", isCurrentMonth = false, hasEvent = true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D1522))
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        // --- Header Section ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.WbSunny,
                    contentDescription = null,
                    tint = Color(0xFFEAB308),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Noor",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF162032))
                    .border(1.dp, Color(0xFF2A3647), RoundedCornerShape(50))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color(0xFFEAB308),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Jakarta, Indonesia",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color(0xFF9CA3AF),
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        // --- Toggle Month/Week Section ---
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val containerWidth = screenWidth - 32.dp - 8.dp
        val indicatorWidth = containerWidth / tabItems.size

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp)
                .clip(CircleShape)
                .background(Color(0xFF162032))
                .padding(4.dp)
        ) {
            val animatedOffset by animateDpAsState(
                targetValue = indicatorWidth * selectedIndex,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
                label = "IndicatorOffsetAnimation"
            )

            Box(
                modifier = Modifier
                    .offset(x = animatedOffset)
                    .width(indicatorWidth)
                    .fillMaxHeight()
                    .clip(CircleShape)
                    .background(Color(0xFFCCA140))
            )

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                tabItems.forEachIndexed { index, title ->
                    val isSelected = index == selectedIndex

                    val animatedTextColor by animateColorAsState(
                        targetValue = if (isSelected) Color(0xFF0D1522) else Color(0xFF9CA3AF),
                        animationSpec = tween(durationMillis = 200),
                        label = "TextColorAnimation"
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(CircleShape)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                selectedIndex = index
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = title,
                            color = animatedTextColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- Calendar Navigation Section ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF162032)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Previous Month",
                        tint = Color(0xFF9CA3AF)
                    )
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "October 2024",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Rabi' al-Thani 1446",
                    color = Color(0xFFCCA140),
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF162032)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Next Month",
                        tint = Color(0xFF9CA3AF)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- Days of Week Section ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            daysOfWeek.forEach { day ->
                Text(
                    text = day,
                    color = Color(0xFF6B7280),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(32.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Calendar Grid Section ---
        LazyVerticalGrid(
            columns = GridCells.Fixed(7),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(360.dp), // Beri height tetap agar LazyGrid bisa scroll bersama parent Column
            userScrollEnabled = false
        ) {
            items(calendarDays) { day ->
                CalendarDayItem(day)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Upcoming Events Section ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Upcoming Events",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "See all",
                    color = Color(0xFFCCA140),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null,
                    tint = Color(0xFFCCA140),
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            EventCard(
                day = "٢٧",
                month = "RAMADAN",
                title = "Laylat al-Qadr",
                description = "The Night of Power, commemorating the first revelation of the Quran.",
                tagText = "AFTER MAGHRIB",
                tagIcon = Icons.Default.Schedule,
                tagColor = Color(0xFFCCA140)
            )

            EventCard(
                day = "٠١",
                month = "SHAWWAL",
                title = "Eid al-Fitr",
                description = "Festival of Breaking the Fast, celebrating the completion of Ramadan.",
                tagText = "PUBLIC HOLIDAY",
                tagIcon = Icons.Default.CalendarToday,
                tagColor = Color(0xFF10B981) // Green color
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun CalendarDayItem(day: CalendarDayData) {
    if (day.gregorian.isEmpty()) {
        Box(modifier = Modifier.size(56.dp))
        return
    }

    Box(
        modifier = Modifier
            .height(64.dp)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        if (day.isSelected) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .shadow(
                        elevation = 16.dp,
                        shape = CircleShape,
                        ambientColor = Color(0xFFCCA140),
                        spotColor = Color(0xFFCCA140)
                    )
                    .clip(CircleShape)
                    .background(Color(0xFFCCA140))
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = day.gregorian,
                color = when {
                    day.isSelected -> Color(0xFF0D1522)
                    day.isCurrentMonth -> Color.White
                    else -> Color(0xFF6B7280)
                },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = day.hijri,
                color = when {
                    day.isSelected -> Color(0xFF0D1522).copy(alpha = 0.8f)
                    day.isCurrentMonth -> Color(0xFFCCA140)
                    else -> Color(0xFF6B7280)
                },
                fontSize = 12.sp,
                fontFamily = FontFamily.Serif
            )

            if (day.hasEvent) {
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(if (day.isSelected) Color(0xFF0D1522) else Color(0xFF10B981))
                )
            } else {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun EventCard(
    day: String,
    month: String,
    title: String,
    description: String,
    tagText: String,
    tagIcon: androidx.compose.ui.graphics.vector.ImageVector,
    tagColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFF162032))
            .border(1.dp, Color(0xFF2A3647), RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF0D1522))
                    .border(1.dp, Color(0xFF2A3647), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = day,
                        color = tagColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = month,
                        color = tagColor,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Default.MoreHoriz,
                        contentDescription = "Options",
                        tint = Color(0xFF6B7280),
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    color = Color(0xFF9CA3AF),
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color(0xFF0D1522))
                        .border(1.dp, Color(0xFF2A3647), RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = tagIcon,
                        contentDescription = null,
                        tint = tagColor,
                        modifier = Modifier.size(12.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = tagText,
                        color = tagColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

data class CalendarDayData(
    val gregorian: String,
    val hijri: String,
    val isCurrentMonth: Boolean,
    val isSelected: Boolean = false,
    val hasEvent: Boolean = false
)