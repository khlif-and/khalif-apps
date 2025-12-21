package com.nafaskarya.muslimdaily.presentation.core.components.menuSection.part

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.HistoryEdu
import androidx.compose.material.icons.outlined.ImportContacts
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import com.nafaskarya.muslimdaily.R

/**
 * Data Model untuk item menu.
 * Ditandai @Immutable agar Compose bisa skip recomposition jika data tidak berubah.
 */
@Immutable
data class MenuItem(
    @StringRes val labelRes: Int,
    val icon: ImageVector
)

/**
 * List Statis untuk menghindari alokasi memori berulang.
 */
val MENU_ITEMS = listOf(
    MenuItem(R.string.menu_quran, Icons.Outlined.MenuBook),
    MenuItem(R.string.menu_hadits, Icons.Outlined.ImportContacts),
    MenuItem(R.string.menu_kitab, Icons.Outlined.LibraryBooks),
    MenuItem(R.string.menu_nabi, Icons.Outlined.HistoryEdu),
    MenuItem(R.string.menu_doa, Icons.Outlined.AutoAwesome),
    MenuItem(R.string.menu_lainnya, Icons.Filled.Apps)
)