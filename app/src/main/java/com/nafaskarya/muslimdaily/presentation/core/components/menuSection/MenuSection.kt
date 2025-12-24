package com.nafaskarya.muslimdaily.presentation.core.components.menuSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.molecules.ExploreCard
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.part.MENU_ITEMS
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuSection(
    dimen: WindowDimensions,
    onMenuClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var showMoreMenu by remember { mutableStateOf(false) }

    val layoutInfo = remember(dimen) {
        MenuLayoutInfo(
            horizontalPadding = dimen.width * 0.05f,
            titleSize = dimen.getResponsiveTextSize(0.06f, min = 20f, max = 28f),
            cardWidth = dimen.width * 0.26f
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(ColorConstant.BackgroundDark)
            .padding(top = Dimens.PaddingLarge)
    ) {
        Text(
            text = stringResource(R.string.menu_section_title),
            fontSize = layoutInfo.titleSize,
            color = ColorConstant.TextWhite,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                start = layoutInfo.horizontalPadding,
                bottom = Dimens.PaddingLarge
            )
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = layoutInfo.horizontalPadding),
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSemiLarge)
        ) {
            items(
                items = MENU_ITEMS,
                key = { it.labelRes },
                contentType = { "menu_item" }
            ) { item ->

                val label = stringResource(item.labelRes)

                ExploreCard(
                    icon = item.icon,
                    label = label,
                    width = layoutInfo.cardWidth,
                    onClick = {
                        if (item.labelRes == R.string.menu_lainnya) {
                            showMoreMenu = true
                        } else {
                            onMenuClick(label)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))
    }

    if (showMoreMenu) {
        MoreMenuSheet(
            onDismissRequest = { showMoreMenu = false },
            onMenuClick = onMenuClick
        )
    }
}

@Immutable
private data class MenuLayoutInfo(
    val horizontalPadding: Dp,
    val titleSize: TextUnit,
    val cardWidth: Dp
)