package com.khalifapps.muslimgenz.presentation.ui.pages.PrayerPages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrayerPage() {
    val scrollState = rememberScrollState()
    val sheetState = rememberModalBottomSheetState()
    var showSheet by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF131A20))
    ) {
        // --- LAPISAN AMBIENT GLOW ---
        Box(
            modifier = Modifier
                .fillMaxSize()
                .blur(150.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(700.dp)
                    .align(Alignment.Center)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(Color(0xFFD4AF37).copy(alpha = 0.15f), Color.Transparent)
                        )
                    )
            )
        }

        // --- KONTEN UI UTAMA ---
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrayerTopBar()
            Spacer(modifier = Modifier.height(24.dp))
            UpcomingPrayerCard(onSetReminderClick = { showSheet = true })
            Spacer(modifier = Modifier.height(32.dp))
            TodayScheduleSection()
            Spacer(modifier = Modifier.height(40.dp))
        }

        // --- BOTTOM SHEET REMINDER ---
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState,
                containerColor = Color(0xFF131A20), // Warna gelap senada
                scrimColor = Color.Black.copy(alpha = 0.7f),
                dragHandle = { BottomSheetDefaults.DragHandle(color = Color.DarkGray) }
            ) {
                ReminderBottomSheetContent(onDismiss = { showSheet = false })
            }
        }
    }
}

@Composable
fun ReminderBottomSheetContent(onDismiss: () -> Unit) {
    var selectedOption by remember { mutableIntStateOf(1) } // Default: At Adzan time

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(bottom = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Set Prayer Reminder",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Choose when you want to be notified for Asr",
            color = Color(0xFF9CA3AF),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Opsi-opsi reminder
        val options = listOf(
            Triple("10 mins before", "03:35 PM", 0),
            Triple("At Adzan time (default)", "ACTIVE", 1),
            Triple("10 mins after", "03:55 PM", 2)
        )

        options.forEach { (title, subtitle, index) ->
            ReminderOptionItem(
                title = title,
                subtitle = subtitle,
                isSelected = selectedOption == index,
                onClick = { selectedOption = index }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol Save
        Button(
            onClick = onDismiss,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Save Reminder",
                color = Color(0xFF131A20),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ReminderOptionItem(
    title: String,
    subtitle: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) Color(0xFFD4AF37) else Color.White.copy(alpha = 0.1f)
    val backgroundColor = if (isSelected) Color(0xFF1B2531).copy(alpha = 0.3f) else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onClick() }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = subtitle,
                color = if (isSelected) Color(0xFFD4AF37) else Color(0xFF9CA3AF),
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        }

        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFD4AF37),
                unselectedColor = Color.DarkGray
            )
        )
    }
}

@Composable
fun UpcomingPrayerCard(onSetReminderClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(32.dp))
            .border(
                width = 1.5.dp,
                color = Color(0xFFD4AF37).copy(alpha = 0.25f),
                shape = RoundedCornerShape(32.dp)
            )
            .background(Color(0xFF1B2531).copy(alpha = 0.03f))
            .padding(vertical = 40.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "UPCOMING PRAYER",
            color = Color(0xFFD4AF37),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Asr",
            color = Color.White,
            fontSize = 56.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Schedule, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "3:45 PM", color = Color(0xFF9CA3AF), fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

        Spacer(modifier = Modifier.height(48.dp))

        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(200.dp)) {
            CircularProgressIndicator(
                progress = 0.65f,
                modifier = Modifier.fillMaxSize(0.85f),
                color = Color(0xFFD4AF37),
                trackColor = Color(0xFF263B55).copy(alpha = 0.4f),
                strokeWidth = 10.dp,
                strokeCap = StrokeCap.Round
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "2h 14m", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                Text(text = "REMAINING", color = Color(0xFF9CA3AF), fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
            }
        }

        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = onSetReminderClick, // Pemicu Bottom Sheet
            modifier = Modifier.fillMaxWidth(0.85f).height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)),
            shape = RoundedCornerShape(27.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
        ) {
            Text(text = "Set Reminder", color = Color(0xFF131A20), fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// --- Komponen lain tetap sama (PrayerTopBar, TodayScheduleSection, ScheduleItem) ---
// (Pastikan TodayScheduleSection dan PrayerTopBar tetap ada di file Anda)

@Composable
fun TodayScheduleSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Today's Schedule", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Surface(color = Color(0xFF1B2531).copy(alpha = 0.5f), shape = RoundedCornerShape(12.dp)) {
                Text(text = "Tuesday, 24 Oct", color = Color(0xFF9CA3AF), fontSize = 12.sp, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ScheduleItem(Icons.Default.WbSunny, "Fajr", "4:28 AM", false)
        ScheduleItem(Icons.Default.WbSunny, "Dhuhr", "11:42 AM", true)
        ScheduleItem(Icons.Default.Cloud, "Asr", "3:45 PM", true, isHighlighted = true)
        ScheduleItem(Icons.Default.WbTwilight, "Maghrib", "5:54 PM", true)
        ScheduleItem(Icons.Default.NightsStay, "Isha", "7:05 PM", false)
    }
}

@Composable
fun ScheduleItem(icon: ImageVector, name: String, time: String, isActive: Boolean, isHighlighted: Boolean = false) {
    var checked by remember { mutableStateOf(isActive) }
    val borderColor = if (isHighlighted) Color(0xFFD4AF37).copy(alpha = 0.5f) else Color.Transparent
    val backgroundColor = if (isHighlighted) Color(0xFF1B2531).copy(alpha = 0.3f) else Color(0xFF1B2531).copy(alpha = 0.15f)
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp).clip(RoundedCornerShape(20.dp)).background(backgroundColor).border(width = if (isHighlighted) 1.5.dp else 0.5.dp, color = if (isHighlighted) borderColor else Color.White.copy(alpha = 0.05f), shape = RoundedCornerShape(20.dp)).padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = if (isHighlighted) Color(0xFFD4AF37) else Color(0xFF9CA3AF), modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = name, color = if (isHighlighted) Color(0xFFD4AF37) else Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = time, color = Color(0xFF9CA3AF), fontSize = 13.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = { checked = it }, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFFD4AF37), uncheckedThumbColor = Color(0xFF9CA3AF), uncheckedTrackColor = Color(0xFF131A20)))
    }
}

@Composable
fun PrayerTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.WbSunny, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Noor", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier.clip(RoundedCornerShape(24.dp)).background(Color(0xFF1B2531).copy(alpha = 0.1f)).border(0.5.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp)).clickable { }.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Jakarta, Indonesia", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.width(12.dp))
            Icon(imageVector = Icons.Default.Edit, contentDescription = null, tint = Color(0xFF9CA3AF), modifier = Modifier.size(14.dp))
        }
    }
}