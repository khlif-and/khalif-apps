package com.nafaskarya.muslimdaily.presentation.guestUser

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nafaskarya.muslimdaily.presentation.core.shared.footer.BottomNav
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerFooter
import com.nafaskarya.muslimdaily.presentation.core.shared.player.PlayerScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions
import com.nafaskarya.muslimdaily.presentation.guestUser.part.*
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestScreen(navController: NavController) {
    val dimen = rememberWindowDimensions()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var showPlayer by remember { mutableStateOf(false) }
    var showShare by remember { mutableStateOf(false) }
    var showMoreMenu by remember { mutableStateOf(false) }
    var showSleepTimer by remember { mutableStateOf(false) }

    val scrimAlpha by calculateScrimAlpha(sheetState, showPlayer)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorConstant.BackgroundDark)
    ) {
        Scaffold(containerColor = ColorConstant.BackgroundDark) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(bottom = 160.dp)
            ) {
                guestHeaderPart(dimen, navController)
                guestCategoryPart(dimen)
                guestMainContentPart(dimen) { showPlayer = true }
                guestDiscoveryPart(navController)
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
                onShareClick = { showShare = true },
                onMoreClick = { showMoreMenu = true },
                onTimerClick = { showSleepTimer = true }
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
        derivedStateOf<Float> {
            try {
                val currentOffset = sheetState.requireOffset()
                val progress = (currentOffset / screenHeightPx).coerceIn(0f, 1f)
                val fadeStartPoint = 0.3f
                val curve = if (progress < fadeStartPoint) 1f
                else 1f - ((progress - fadeStartPoint) / (1f - fadeStartPoint))
                (curve * 0.85f).coerceIn(0f, 1f)
            } catch (e: Exception) {
                if (isVisible) 0.85f else 0f
            }
        }
    }
}