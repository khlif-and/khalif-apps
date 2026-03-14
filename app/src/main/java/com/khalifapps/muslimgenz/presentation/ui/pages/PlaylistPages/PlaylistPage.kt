package com.khalifapps.muslimgenz.presentation.ui.pages.PlaylistPages

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.R

data class TrackItem(
    val title: String,
    val artist: String,
    val duration: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistPage(
    onNavigateBack: () -> Unit,
    onNavigateToShare: () -> Unit // Tambahan parameter navigasi share
) {
    var selectedTrack by remember { mutableStateOf<TrackItem?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val blurRadius by animateDpAsState(
        targetValue = if (selectedTrack != null) 16.dp else 0.dp,
        label = "blurRadius"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF131A20))
            .blur(blurRadius)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .navigationBarsPadding()
        ) {
            Spacer(modifier = Modifier.statusBarsPadding())
            Spacer(modifier = Modifier.height(64.dp))

            Spacer(modifier = Modifier.height(32.dp))

            PlaylistCoverSection()

            Spacer(modifier = Modifier.height(24.dp))

            PlaylistInfoSection()

            Spacer(modifier = Modifier.height(24.dp))

            PlaylistActionRow(
                onShareClick = onNavigateToShare // Teruskan ke baris aksi
            )

            Spacer(modifier = Modifier.height(32.dp))

            PlaylistTrackList(
                onMoreClick = { track ->
                    selectedTrack = track
                }
            )

            Spacer(modifier = Modifier.height(48.dp))
        }

        PlaylistTopBar(
            onBackClick = onNavigateBack,
            onSearchClick = { },
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }

    if (selectedTrack != null) {
        ModalBottomSheet(
            onDismissRequest = { selectedTrack = null },
            sheetState = sheetState,
            containerColor = Color(0xE6131A20),
            dragHandle = { BottomSheetDefaults.DragHandle() },
            scrimColor = BottomSheetDefaults.ScrimColor,
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            TrackBottomSheetContent(
                track = selectedTrack!!,
                onShareClick = {
                    selectedTrack = null // Tutup bottom sheet saat tombol share diklik
                    onNavigateToShare()  // Navigasi ke halaman share
                }
            )
        }
    }
}

@Composable
fun TrackBottomSheetContent(
    track: TrackItem,
    onShareClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = track.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = track.title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = track.artist,
                    color = Color(0xFFD4AF37),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Like",
                tint = Color(0xFF3AC4B2),
                modifier = Modifier.size(24.dp)
            )
        }

        HorizontalDivider(
            color = Color(0x1AFFFFFF),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BottomSheetMenuItem(icon = Icons.Default.Add, text = "Add to Queue")
        BottomSheetMenuItem(icon = Icons.Filled.PlayArrow, text = "Go to Album")
        BottomSheetMenuItem(icon = Icons.Default.Person, text = "View Reciter Details")
        BottomSheetMenuItem(icon = Icons.Default.KeyboardArrowDown, text = "Download for Offline", isPremium = true)

        // Panggil onShareClick saat tombol share di Bottom Sheet ditekan
        BottomSheetMenuItem(
            icon = Icons.Outlined.Share,
            text = "Share to Instagram Stories",
            onClick = onShareClick
        )

        BottomSheetMenuItem(icon = Icons.Default.Create, text = "Add to Spiritual Journal")
        BottomSheetMenuItem(icon = Icons.Default.Warning, text = "Report Content", isDestructive = true)
    }
}

@Composable
fun BottomSheetMenuItem(
    icon: ImageVector,
    text: String,
    isPremium: Boolean = false,
    isDestructive: Boolean = false,
    onClick: () -> Unit = {} // Tambahkan parameter onClick
) {
    val contentColor = if (isDestructive) Color(0xFFE57373) else Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() } // Jalankan onClick saat ditekan
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            color = contentColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )

        if (isPremium) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF263B55))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "PREMIUM",
                    color = Color(0xFF3AC4B2),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun PlaylistTrackList(
    modifier: Modifier = Modifier,
    onMoreClick: (TrackItem) -> Unit
) {
    val tracks = listOf(
        TrackItem("Surah Ar-Rahman", "Mishary Rashid Alafasy", "18:24", R.drawable.ic_launcher_background),
        TrackItem("Morning Adhkar", "Omar Hisham Al Arabi", "42:10", R.drawable.ic_launcher_background),
        TrackItem("99 Names of Allah", "Mustafa Cezar", "06:45", R.drawable.ic_launcher_background),
        TrackItem("Surah Al-Mulk", "Saud Al-Shuraim", "12:30", R.drawable.ic_launcher_background),
        TrackItem("Astaghfirullah 100x", "Meditation Dhikr", "05:22", R.drawable.ic_launcher_background)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        tracks.forEachIndexed { index, track ->
            TrackItemRow(
                index = index + 1,
                track = track,
                onMoreClick = { onMoreClick(track) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun TrackItemRow(
    index: Int,
    track: TrackItem,
    onMoreClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF1B2531))
            .clickable { }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = index.toString(),
            color = Color(0xFF6B7280),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(24.dp)
        )

        Image(
            painter = painterResource(id = track.imageRes),
            contentDescription = track.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = track.title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = track.artist,
                color = Color(0xFF9CA3AF),
                fontSize = 13.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = track.duration,
            color = Color(0xFF6B7280),
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More options",
            tint = Color(0xFF6B7280),
            modifier = Modifier
                .clickable { onMoreClick() }
                .padding(4.dp)
        )
    }
}

@Composable
fun PlaylistInfoSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "CURATED PLAYLIST",
            color = Color(0xFFD4AF37),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Soulful Morning\nDhikr",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 38.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Creator Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Khalif • 24 tracks, 2 hrs 15 mins",
                color = Color(0xFF9CA3AF),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun PlaylistActionRow(
    modifier: Modifier = Modifier,
    onShareClick: () -> Unit // Terima klik dari Parent
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Like",
                tint = Color(0xFFD4AF37),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { }
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Download",
                tint = Color(0xFFA0AAB2),
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF263B55))
                    .padding(4.dp)
                    .clickable { }
            )

            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = "Share",
                tint = Color(0xFFA0AAB2),
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onShareClick() } // Panggil aksi navigasi ke Share
            )
        }

        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color(0xFFD4AF37))
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color(0xFF131A20),
                modifier = Modifier.size(36.dp)
            )
        }
    }
}

@Composable
fun PlaylistCoverSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Playlist Cover",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(32.dp))
        )
    }
}

@Composable
fun PlaylistTopBar(
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xD9263B55))
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable { onBackClick() }
        )

        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .clickable { onSearchClick() }
        )
    }
}