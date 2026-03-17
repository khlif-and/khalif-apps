package com.khalifapps.muslimgenz.presentation.ui.organisms.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness3
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.HomeStrings
import com.khalifapps.muslimgenz.presentation.ui.atoms.home.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuGrid(
    onNavigateToPrayer: () -> Unit,
    onNavigateToCalendar: () -> Unit
) {
    val dimens = AppTheme.dimens
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MenuItem(icon = Icons.Default.MenuBook, label = HomeStrings.MENU_QURAN)
            MenuItem(icon = Icons.Default.List, label = HomeStrings.MENU_HADITH)
            MenuItem(icon = Icons.Default.Edit, label = HomeStrings.MENU_STORIES)
            MenuItem(
                icon = Icons.Default.GridView,
                label = HomeStrings.MENU_ALL,
                onClick = { showBottomSheet = true }
            )
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color(0xFF162032),
            windowInsets = WindowInsets(0)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(horizontal = dimens.paddingLarge, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    MenuItem(
                        icon = Icons.Default.VolumeUp,
                        label = HomeStrings.MENU_DAKWAH
                    )
                    MenuItem(
                        icon = Icons.Default.Brightness3,
                        label = HomeStrings.MENU_PRAYER,
                        onClick = {
                            showBottomSheet = false
                            onNavigateToPrayer()
                        }
                    )
                    MenuItem(
                        icon = Icons.Default.DateRange,
                        label = HomeStrings.MENU_CALENDAR,
                        onClick = {
                            showBottomSheet = false
                            onNavigateToCalendar()
                        }
                    )
                    MenuItem(
                        icon = Icons.Default.Explore,
                        label = HomeStrings.MENU_QIBLA
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}