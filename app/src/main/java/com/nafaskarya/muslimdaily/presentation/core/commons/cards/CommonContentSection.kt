package com.nafaskarya.muslimdaily.presentation.core.commons.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

/**
 * Komponen Section Generic yang Reusable.
 * Bisa digunakan untuk Guest, Home, atau fitur lainnya.
 *
 * @param T Tipe data item (misal: ContentItem, Song, Video, dll).
 * @param title Judul section.
 * @param items List data yang akan ditampilkan.
 * @param dimen Utils WindowDimensions untuk responsivitas.
 * @param onSeeAllClick Aksi saat tombol "Lihat semuanya" diklik.
 * @param itemContent Composable function untuk merender setiap item (misal: SharedVerticalImageCard).
 */
@Composable
fun <T> CommonContentSection(
    title: String,
    items: List<T>,
    dimen: WindowDimensions,
    onSeeAllClick: () -> Unit = {},
    itemContent: @Composable (T) -> Unit
) {
    val horizontalPadding = dimen.width * 0.05f
    val titleSize = dimen.getResponsiveTextSize(0.045f, min = 18f, max = 22f)

    Column {
        // --- Header Section ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = titleSize,
                fontWeight = FontWeight.SemiBold,
                color = ColorConstant.TextWhite
            )
            Text(
                text = stringResource(id = R.string.guest_see_all),
                fontSize = Dimens.TextSmall,
                color = ColorConstant.TextGray,
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }

        // --- List Content (LazyRow) ---
        LazyRow(
            contentPadding = PaddingValues(horizontal = horizontalPadding),
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)
        ) {
            items(
                items = items,
                // Kita gunakan hashCode sebagai key default yang aman untuk generic
                key = { it.hashCode() }
            ) { item ->
                itemContent(item)
            }
        }

        Spacer(modifier = Modifier.height(Dimens.PaddingXLarge))
    }
}