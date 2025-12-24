package com.nafaskarya.muslimdaily.presentation.core.components.menuSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.molecules.ExploreCard
import com.nafaskarya.muslimdaily.presentation.core.components.menuSection.part.CATEGORIZED_MENU_ITEMS
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreMenuSheet(
    sheetState: SheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    ),
    onDismissRequest: () -> Unit,
    onMenuClick: (String) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = ColorConstant.MoreMenuSheetBackground,
        dragHandle = null
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .padding(top = Dimens.PaddingLarge)
        ) {
            Text(
                text = stringResource(R.string.menu_lainnya),
                fontSize = Dimens.TextTitle,
                fontWeight = FontWeight.Bold,
                color = ColorConstant.TextWhite,
                modifier = Modifier
                    .padding(horizontal = Dimens.PaddingXLarge)
                    .padding(bottom = Dimens.PaddingLarge)
                    .align(Alignment.CenterHorizontally)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(
                    start = Dimens.PaddingLarge,
                    end = Dimens.PaddingLarge,
                    bottom = Dimens.PaddingXLarge
                ),
                verticalArrangement = Arrangement.spacedBy(Dimens.PaddingLarge),
                horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingLarge),
                modifier = Modifier.weight(1f)
            ) {
                CATEGORIZED_MENU_ITEMS.forEach { category ->
                    item(span = { GridItemSpan(4) }) {
                        Text(
                            text = category.title,
                            color = ColorConstant.TextGray,
                            fontSize = Dimens.TextBody,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(top = Dimens.PaddingLarge, bottom = Dimens.PaddingSmall)
                                .fillMaxWidth()
                        )
                    }

                    items(category.items) { item ->
                        val label = stringResource(item.labelRes)

                        ExploreCard(
                            icon = item.icon,
                            label = label,
                            width = 80.dp,
                            onClick = {
                                onMenuClick(label)
                                onDismissRequest()
                            }
                        )
                    }
                }
            }
        }
    }
}