package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@Composable
fun GuestHeaderSection(
    modifier: Modifier = Modifier,
    dimen: WindowDimensions
) {
    val items = List(6) { "Semua" }
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(ColorConstant.BackgroundDark)
            .padding(
                start = Dimens.PaddingXLarge,
                top = Dimens.PaddingSmall,
                bottom = Dimens.PaddingLarge
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileAvatar()

        Spacer(modifier = Modifier.width(Dimens.PaddingSemiLarge))

        CategoryList(
            categories = items,
            selectedIndex = selectedIndex,
            onCategoryClick = { selectedIndex = it },
            modifier = Modifier.weight(1f)
        )
    }
}