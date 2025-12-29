package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens

@Composable
fun CategoryList(
    categories: List<String>,
    selectedIndex: Int,
    onCategoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val activeColor = Color(0xFFFF6F00)
    val backgroundColor = ColorConstant.BackgroundDark

    Box(modifier = modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                end = Dimens.PaddingLarge,
                start = 0.dp
            )
        ) {
            item {
                Spacer(modifier = Modifier.width(Dimens.PaddingMedium))
            }

            itemsIndexed(categories) { index, item ->
                val isSelected = index == selectedIndex
                val boxBackground = if (isSelected) activeColor else ColorConstant.ProfileSurface

                Box(
                    modifier = Modifier
                        .background(
                            color = boxBackground,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { onCategoryClick(index) }
                        .padding(
                            horizontal = Dimens.PaddingLarge,
                            vertical = Dimens.PaddingMedium
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item,
                        color = ColorConstant.TextWhite,
                        fontSize = Dimens.TextBody
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .width(Dimens.PaddingXLarge)
                .fillMaxHeight()
                .height(40.dp)
                .align(Alignment.CenterStart)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            backgroundColor,
                            Color.Transparent
                        )
                    )
                )
        )
    }
}