package com.nafaskarya.muslimdaily.presentation.core.shared.player

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.PlayerScreenBackground
import com.nafaskarya.muslimdaily.presentation.core.shared.player.moreMenu.MoreMenuBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.shared.player.part.*
import com.nafaskarya.muslimdaily.presentation.core.shared.player.sharing.ShareScreenBottomSheet
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerScreenBottomSheet(
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    onTimerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = PlayerScreenBackground,
        scrimColor = Color.Transparent,
        dragHandle = null,
        modifier = modifier
    ) {
        // PERBAIKAN: PlayerContent sekarang tidak butuh callback Share/More dari luar
        PlayerContent(
            onCollapse = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        onDismissRequest()
                    }
                }
            },
            onTimerClick = onTimerClick
        )
    }
}

@Composable
fun PlayerContent(
    onCollapse: () -> Unit,
    onTimerClick: () -> Unit
) {
    val dimen = rememberWindowDimensions()

    // State internal agar tetap di dalam Player
    var showMoreMenu by remember { mutableStateOf(false) }
    var showShareSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = dimen.width * 0.06f,
                    vertical = dimen.getResponsiveHeight(0.02f)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PlayerHeaderSection(
                modifier = Modifier.fillMaxWidth(),
                onCollapse = onCollapse,
                onMoreClick = { showMoreMenu = true } // 👈 Gunakan state local
            )

            Spacer(modifier = Modifier.weight(1f))

            PlayerArtworkSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(dimen.width * 0.02f)
            )

            Spacer(modifier = Modifier.weight(1f))

            PlayerInfoSection(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))

            PlayerSeekBarSection()

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.02f)))

            PlayerControlsSection(onTimerClick = onTimerClick)

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.04f)))

            PlayerFooterActionsSection(
                onShareClick = { showShareSheet = true } // 👈 Gunakan state local
            )

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.02f)))
        }

        // --- OVERLAY SECTION ---

        if (showMoreMenu) {
            MoreMenuBottomSheet(
                onDismissRequest = { showMoreMenu = false }
            )
        }

        if (showShareSheet) {
            // 👈 Gunakan BottomSheet wrapper agar efeknya sama dengan More Menu
            ShareScreenBottomSheet(
                onDismissRequest = { showShareSheet = false },
                onBackClick = { showShareSheet = false }
            )
        }
    }
}