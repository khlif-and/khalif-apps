package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.routes.AppDestination
import com.nafaskarya.muslimdaily.presentation.core.shared.footer.BottomNav
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerFooter
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions
import com.nafaskarya.muslimdaily.presentation.guestUser.part.*
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.shared.player.timer.SleepTimerBottomSheet
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(navController: NavController) {
    val dimen = rememberWindowDimensions()
    val density = LocalDensity.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val headerHeightDp = 210.dp
    val headerHeightPx = with(density) { headerHeightDp.toPx() }

    var topBarOffsetHeightPx by remember { mutableStateOf(0f) }
    var showPlayer by remember { mutableStateOf(false) }
    var showSleepTimer by remember { mutableStateOf(false) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffsetHeightPx + delta
                topBarOffsetHeightPx = newOffset.coerceIn(-headerHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    val scrimAlpha by calculateScrimAlpha(sheetState, showPlayer)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorConstant.BackgroundDark)
            .nestedScroll(nestedScrollConnection)
    ) {
        Scaffold(containerColor = ColorConstant.BackgroundDark) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 160.dp)
            ) {
                item { Spacer(modifier = Modifier.height(headerHeightDp)) }

                guestMainContentPart(dimen) { showPlayer = true }
                guestDiscoveryPart(navController)
            }
        }

        Box(
            modifier = Modifier
                .offset { IntOffset(x = 0, y = topBarOffsetHeightPx.roundToInt()) }
                .graphicsLayer {
                    alpha = 1f + (topBarOffsetHeightPx / headerHeightPx)
                }
                .background(ColorConstant.BackgroundDark)
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                GuestHeaderSection(dimen) {
                    navController.navigate(AppDestination.Profile.route)
                }
                GuestCategorySection(dimen)
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Box(modifier = Modifier.clickable { showPlayer = true }) {
                PlayerFooter()
            }
            BottomNav()
        }

        if (showPlayer) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = scrimAlpha))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showPlayer = false }
            )

            PlayerScreenBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { showPlayer = false },
                onTimerClick = { showSleepTimer = true }
            )
        }

        if (showSleepTimer) {
            SleepTimerBottomSheet(
                onDismissRequest = { showSleepTimer = false },
                onTimerSelected = { showSleepTimer = false }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun calculateScrimAlpha(sheetState: SheetState, isVisible: Boolean): State<Float> {
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val screenHeightPx = with(density) { configuration.screenHeightDp.dp.toPx() }

    return remember(sheetState, isVisible) {
        derivedStateOf {
            try {
                val currentOffset = sheetState.requireOffset()
                val progress = (currentOffset / screenHeightPx).coerceIn(0f, 1f)
                ((1f - progress) * 0.85f).coerceIn(0f, 1f)
            } catch (e: Exception) {
                if (isVisible) 0f else 0f
            }
        }
    }
}