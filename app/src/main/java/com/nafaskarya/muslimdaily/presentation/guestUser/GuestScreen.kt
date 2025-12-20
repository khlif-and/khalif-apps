package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.shared.footer.BottomNav
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerFooter
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions
import com.nafaskarya.muslimdaily.presentation.guestUser.part.*
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.timer.SleepTimerBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.ProfileSidebar
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(navController: NavController) {
    val dimen = rememberWindowDimensions()
    val density = LocalDensity.current

    val headerHeightDp = 210.dp
    val headerHeightPx = remember(density) { with(density) { headerHeightDp.toPx() } }
    val sidebarWidthPx = remember(dimen.width, density) { with(density) { (dimen.width * 0.8f).toPx() } }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val interactionSource = remember { MutableInteractionSource() }

    var topBarOffsetHeightPx by remember { mutableStateOf(0f) }
    var showPlayer by remember { mutableStateOf(false) }
    var showSleepTimer by remember { mutableStateOf(false) }
    var isSidebarOpen by remember { mutableStateOf(false) }

    val contentTranslationX by animateFloatAsState(
        targetValue = if (isSidebarOpen) sidebarWidthPx else 0f,
        animationSpec = spring(stiffness = 800f),
        label = "SidebarAnimation"
    )

    val contentScale by animateFloatAsState(
        targetValue = if (isSidebarOpen) 0.92f else 1f,
        animationSpec = spring(stiffness = 800f),
        label = "ContentScale"
    )

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                if (isSidebarOpen) return Offset.Zero
                val delta = available.y
                val newOffset = topBarOffsetHeightPx + delta
                topBarOffsetHeightPx = newOffset.coerceIn(-headerHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    val headerAlpha by remember {
        derivedStateOf { (1f + (topBarOffsetHeightPx / headerHeightPx)).coerceIn(0f, 1f) }
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFF121212))) {
        ProfileSidebar(modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight())

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(contentTranslationX.roundToInt(), 0) }
                .graphicsLayer {
                    scaleX = contentScale
                    scaleY = contentScale
                    shape = RoundedCornerShape(if (isSidebarOpen) 28.dp else 0.dp)
                    clip = isSidebarOpen
                }
                .background(ColorConstant.BackgroundDark)
                .nestedScroll(nestedScrollConnection)
                .clickable(
                    enabled = isSidebarOpen,
                    interactionSource = interactionSource,
                    indication = null
                ) { isSidebarOpen = false }
        ) {
            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = {
                    Column {
                        Box(modifier = Modifier.clickable(interactionSource = interactionSource, indication = null) { showPlayer = true }) {
                            PlayerFooter()
                        }
                        BottomNav()
                    }
                }
            ) { paddingValues ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(top = paddingValues.calculateTopPadding(), bottom = 120.dp)
                ) {
                    item { Spacer(modifier = Modifier.height(headerHeightDp)) }
                    guestMainContentPart(dimen) { showPlayer = true }
                    guestDiscoveryPart(navController)
                }
            }

            Box(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ColorConstant.BackgroundDark)
                        .statusBarsPadding()
                )

                Box(
                    modifier = Modifier
                        .offset { IntOffset(x = 0, y = topBarOffsetHeightPx.roundToInt()) }
                        .graphicsLayer { alpha = headerAlpha }
                        .background(ColorConstant.BackgroundDark)
                        .fillMaxWidth()
                        .statusBarsPadding()
                ) {
                    Column(modifier = Modifier.padding(bottom = 12.dp)) {
                        GuestHeaderSection(dimen) { isSidebarOpen = !isSidebarOpen }
                        GuestCategorySection(dimen)
                    }
                }
            }
        }

        if (showPlayer) {
            PlayerScreenBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { showPlayer = false },
                onTimerClick = { showSleepTimer = true }
            )
        }
    }
}