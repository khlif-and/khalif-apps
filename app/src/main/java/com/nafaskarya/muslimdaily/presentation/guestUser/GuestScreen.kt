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

    // Tinggi maksimal header (Header + Category + Spacing) dalam DP
    val headerHeightDp = 210.dp
    val headerHeightPx = with(density) { headerHeightDp.toPx() }

    // State untuk mengontrol offset (perpindahan) secara halus
    var topBarOffsetHeightPx by remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = topBarOffsetHeightPx + delta
                // Membatasi agar offset tidak lebih dari 0 dan tidak kurang dari minus tinggi header
                topBarOffsetHeightPx = newOffset.coerceIn(-headerHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    val scrimAlpha by calculateScrimAlpha(sheetState, true)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorConstant.BackgroundDark)
            .nestedScroll(nestedScrollConnection)
    ) {
        // Konten Utama
        Scaffold(containerColor = ColorConstant.BackgroundDark) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 160.dp)
            ) {
                // Spacer ini harus sama dengan tinggi header agar konten awal tidak tertutup
                item { Spacer(modifier = Modifier.height(headerHeightDp)) }

                guestMainContentPart(dimen) { /* showPlayer logic */ }
                guestDiscoveryPart(navController)
            }
        }

        // --- TOP SECTION (Efek Tertelan) ---
        // Kita menggunakan Modifier.offset dan graphicsLayer untuk efek halus
        Box(
            modifier = Modifier
                .offset { IntOffset(x = 0, y = topBarOffsetHeightPx.roundToInt()) }
                .graphicsLayer {
                    // Efek "Tertelan": Semakin ke atas, semakin transparan
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

        // Footer Section
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            PlayerFooter()
            BottomNav()
        }

        // Modal Sheets
        if (false) { // Placeholder logic player
            PlayerScreenBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { },
                onTimerClick = { }
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
                ( (1f - progress) * 0.85f).coerceIn(0f, 1f)
            } catch (e: Exception) {
                if (isVisible) 0.85f else 0f
            }
        }
    }
}