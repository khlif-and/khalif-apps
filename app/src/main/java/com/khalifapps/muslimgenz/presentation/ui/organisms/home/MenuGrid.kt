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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.HomeStrings
import com.khalifapps.muslimgenz.presentation.ui.atoms.home.MenuItem

@Composable
fun MenuGrid(
    onNavigateToPrayer: () -> Unit,
    onNavigateToCalendar: () -> Unit
) {
    val dimens = AppTheme.dimens
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MenuItem(icon = Icons.Default.MenuBook, label = HomeStrings.MENU_QURAN)
            MenuItem(icon = Icons.Default.List, label = HomeStrings.MENU_HADITH)
            MenuItem(icon = Icons.Default.Edit, label = HomeStrings.MENU_STORIES)
            MenuItem(icon = Icons.Default.VolumeUp, label = HomeStrings.MENU_DAKWAH)
        }
        Spacer(modifier = Modifier.height(dimens.paddingLarge))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MenuItem(
                icon = Icons.Default.Brightness3,
                label = HomeStrings.MENU_PRAYER,
                onClick = onNavigateToPrayer
            )
            MenuItem(
                icon = Icons.Default.DateRange,
                label = HomeStrings.MENU_CALENDAR,
                onClick = onNavigateToCalendar
            )
            MenuItem(icon = Icons.Default.Explore, label = HomeStrings.MENU_QIBLA)
            MenuItem(icon = Icons.Default.GridView, label = HomeStrings.MENU_ALL)
        }
    }
}