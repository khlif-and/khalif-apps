package com.nafaskarya.muslimdaily.presentation.core.components.menuSection.part

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CompassCalibration
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.HistoryEdu
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Mosque
import androidx.compose.material.icons.outlined.VolunteerActivism
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.nafaskarya.muslimdaily.R

@Immutable
data class MenuItem(
    @StringRes val labelRes: Int,
    val icon: ImageVector
)

@Immutable
data class MenuCategory(
    val title: String,
    val items: List<MenuItem>
)

val MENU_ITEMS = listOf(
    MenuItem(R.string.menu_quran, Icons.Outlined.MenuBook),
    MenuItem(R.string.menu_hadits, Icons.Outlined.ImportContacts),
    MenuItem(R.string.menu_kitab, Icons.Outlined.LibraryBooks),
    MenuItem(R.string.menu_nabi, Icons.Outlined.HistoryEdu),
    MenuItem(R.string.menu_doa, Icons.Outlined.AutoAwesome),
    MenuItem(R.string.menu_lainnya, Icons.Filled.Apps)
)

val CATEGORIZED_MENU_ITEMS = listOf(
    MenuCategory(
        title = "Ibadah & Harian",
        items = listOf(
            MenuItem(R.string.menu_quran, Icons.Outlined.MenuBook),
            MenuItem(R.string.menu_hadits, Icons.Outlined.ImportContacts),
            MenuItem(R.string.menu_kitab, Icons.Outlined.LibraryBooks),
            MenuItem(R.string.menu_nabi, Icons.Outlined.HistoryEdu),
            MenuItem(R.string.menu_doa, Icons.Outlined.AutoAwesome),
            MenuItem(R.string.menu_lainnya, Icons.Filled.Apps)
        )
    ),
    MenuCategory(
        title = "Kisah & Edukasi",
        items = listOf(
            MenuItem(R.string.menu_quran, Icons.Outlined.MenuBook),
            MenuItem(R.string.menu_hadits, Icons.Outlined.ImportContacts),
            MenuItem(R.string.menu_kitab, Icons.Outlined.LibraryBooks),
            MenuItem(R.string.menu_nabi, Icons.Outlined.HistoryEdu),
            MenuItem(R.string.menu_doa, Icons.Outlined.AutoAwesome),
            MenuItem(R.string.menu_lainnya, Icons.Filled.Apps)
        )
    ),
    MenuCategory(
        title = "Sosial & Lainnya",
        items = listOf(
            MenuItem(R.string.menu_quran, Icons.Outlined.MenuBook),
            MenuItem(R.string.menu_hadits, Icons.Outlined.ImportContacts),
            MenuItem(R.string.menu_kitab, Icons.Outlined.LibraryBooks),
            MenuItem(R.string.menu_nabi, Icons.Outlined.HistoryEdu),
            MenuItem(R.string.menu_doa, Icons.Outlined.AutoAwesome),
            MenuItem(R.string.menu_lainnya, Icons.Filled.Apps)
        )
    )
)