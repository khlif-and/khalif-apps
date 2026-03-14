package com.khalifapps.muslimgenz.presentation.ui.pages.LoFiPages

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardDoubleArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoFiPage(
    onNavigateBack: () -> Unit
) {
    var showMoreBottomSheet by remember { mutableStateOf(false) }
    var showMeaningBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val blurRadius by animateDpAsState(
        targetValue = if (showMoreBottomSheet || showMeaningBottomSheet) 16.dp else 0.dp,
        label = "blurRadius"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF131B2A))
            .blur(blurRadius)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LoFiTopBar(
                onBackClick = onNavigateBack,
                onMoreClick = { showMoreBottomSheet = true }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "سُبْحَانَ اللَّهِ",
                    style = TextStyle(
                        fontSize = 72.sp,
                        color = Color(0xFFD4AF37),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color(0x80D4AF37),
                            offset = Offset(0f, 0f),
                            blurRadius = 40f
                        )
                    ),
                    modifier = Modifier.padding(bottom = 64.dp)
                )

                Text(
                    text = "Subhanallah",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "\"Glory be to Allah\"",
                    color = Color(0xFF9CA3AF),
                    fontSize = 16.sp,
                    fontStyle = FontStyle.Italic
                )
            }

            PlayerBottomPanel(
                onMeaningClick = { showMeaningBottomSheet = true }
            )
        }
    }

    if (showMoreBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showMoreBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color(0xE6131B2A),
            dragHandle = { BottomSheetDefaults.DragHandle() },
            scrimColor = BottomSheetDefaults.ScrimColor,
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            LoFiBottomSheetContent()
        }
    }

    if (showMeaningBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showMeaningBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color(0xE6131B2A),
            dragHandle = { Spacer(modifier = Modifier.height(0.dp)) },
            scrimColor = BottomSheetDefaults.ScrimColor,
            windowInsets = WindowInsets(0, 0, 0, 0),
            modifier = Modifier.fillMaxHeight(0.9f)
        ) {
            MeaningBottomSheetContent(
                onCloseClick = { showMeaningBottomSheet = false }
            )
        }
    }
}

@Composable
fun MeaningBottomSheetContent(
    onCloseClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x1AFFFFFF))
                    .clickable { onCloseClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color(0xFF9CA3AF),
                    modifier = Modifier.size(20.dp)
                )
            }

            Text(
                text = "MEANING & REFLECTION",
                color = Color(0xFFD4AF37),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "سُبْحَانَ اللَّهِ",
            style = TextStyle(
                fontSize = 64.sp,
                color = Color(0xFFD4AF37),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Subhanallah",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Glory be to Allah",
            color = Color(0xFF9CA3AF),
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(1.dp)
                        .background(Color(0xFFD4AF37))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Reflection",
                    color = Color(0xFFD4AF37),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "To glorify Allah is to acknowledge His perfection and freedom from any deficiency. This dhikr is a key to tranquility, reminding the heart that even in chaos, there is a Divine order that is flawless. Every \"Subhanallah\" is a return to awe, stripping away the ego's distractions to witness the infinite purity of the Creator.",
                color = Color(0xFF9CA3AF),
                fontSize = 15.sp,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFF1B2531))
                    .padding(24.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = Color(0xFFD4AF37),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "RELATED AYAH",
                        color = Color(0xFFD4AF37),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "سَبِّحِ اسْمَ رَبِّكَ الْأَعْلَى",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "\"Glorify the name of your Lord, the Most High\"",
                    color = Color(0xFF9CA3AF),
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD4AF37)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = null,
                        tint = Color(0xFF131A20),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Share Wisdom",
                        color = Color(0xFF131A20),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                    border = BorderStroke(1.dp, Color(0xFFD4AF37).copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Book,
                        contentDescription = null,
                        tint = Color(0xFFD4AF37),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Save to Diary",
                        color = Color(0xFFD4AF37),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Spacer(modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars))
        }
    }
}

@Composable
fun LoFiBottomSheetContent() {
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
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "SubhanAllah",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Noor Lo-fi Sessions",
                    color = Color(0xFF9CA3AF),
                    fontSize = 13.sp
                )
            }
        }

        HorizontalDivider(
            color = Color(0x1AFFFFFF),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        LoFiBottomSheetItem(
            icon = Icons.Default.GraphicEq,
            title = "Audio Quality",
            subtitle = {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF9CA3AF))) {
                            append("Current setting: ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFFD4AF37))) {
                            append("High")
                        }
                    },
                    fontSize = 12.sp
                )
            }
        )

        LoFiBottomSheetItem(icon = Icons.Default.Article, title = "View Full Lyrics")
        LoFiBottomSheetItem(icon = Icons.Default.PlaylistAdd, title = "Add to Playlist")
        LoFiBottomSheetItem(icon = Icons.Default.Timer, title = "Sleep Timer")
        LoFiBottomSheetItem(icon = Icons.Default.KeyboardArrowDown, title = "Download for Offline")
        LoFiBottomSheetItem(icon = Icons.Default.Share, title = "Share to Instagram Stories")

        HorizontalDivider(
            color = Color(0x1AFFFFFF),
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
        )

        LoFiBottomSheetItem(
            icon = Icons.Default.Warning,
            title = "Report an Issue",
            contentColor = Color(0xFFE57373)
        )
    }
}

@Composable
fun LoFiBottomSheetItem(
    icon: ImageVector,
    title: String,
    contentColor: Color = Color.White,
    subtitle: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 24.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = contentColor,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = contentColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            if (subtitle != null) {
                Spacer(modifier = Modifier.height(2.dp))
                subtitle()
            }
        }
    }
}

@Composable
fun PlayerBottomPanel(
    onMeaningClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color(0xFF1B2531))
            .padding(horizontal = 32.dp, vertical = 24.dp)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(48.dp)
                .height(4.dp)
                .clip(CircleShape)
                .background(Color(0xFF374151))
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .clip(CircleShape)
                .background(Color(0xFF374151))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.35f)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD4AF37))
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "02:45",
                color = Color(0xFF9CA3AF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "07:00",
                color = Color(0xFF9CA3AF),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Shuffle,
                contentDescription = "Shuffle",
                tint = Color(0xFF9CA3AF),
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )

            Icon(
                imageVector = Icons.Default.SkipPrevious,
                contentDescription = "Previous",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { }
            )

            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD4AF37))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = Color(0xFF131B2A),
                    modifier = Modifier.size(40.dp)
                )
            }

            Icon(
                imageVector = Icons.Default.SkipNext,
                contentDescription = "Next",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { }
            )

            Icon(
                imageVector = Icons.Default.Repeat,
                contentDescription = "Repeat",
                tint = Color(0xFFD4AF37),
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlayerActionButton(
                icon = Icons.Default.Favorite,
                label = "LIKE",
                onClick = {}
            )
            PlayerActionButton(
                icon = Icons.Default.KeyboardDoubleArrowUp,
                label = "MEANING",
                onClick = onMeaningClick
            )
            PlayerActionButton(
                icon = Icons.Default.Timer,
                label = "SLEEP",
                onClick = {}
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun PlayerActionButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFF9CA3AF),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            color = Color(0xFF9CA3AF),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        )
    }
}

@Composable
fun LoFiTopBar(
    onBackClick: () -> Unit,
    onMoreClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0x1AFFFFFF))
                .clickable { onBackClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "NOW PLAYING",
                color = Color(0xFFD4AF37),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Lo-fi Dhikr Beats",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0x1AFFFFFF))
                .clickable { onMoreClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}