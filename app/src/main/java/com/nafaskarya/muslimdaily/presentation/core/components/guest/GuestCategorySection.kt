package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

private val CATEGORIES = listOf("All", "Dakwah", "Kajian", "Podcast", "Murottal")

private val TextPaddingModifier = Modifier.padding(
    horizontal = Dimens.PaddingXLarge,
    vertical = Dimens.PaddingMedium
)

@Composable
fun GuestCategorySection(dimen: WindowDimensions) {
    val contentPadding = remember(dimen.width) {
        PaddingValues(horizontal = dimen.width * 0.05f)
    }

    val onCategoryClick = remember { {} }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSemiLarge)
    ) {
        items(
            items = CATEGORIES,
            key = { it },
            contentType = { "category_chip" }
        ) { category ->
            CategoryChip(
                category = category,
                isSelected = category == "All",
                onClick = onCategoryClick
            )
        }
    }
}

@Composable
private fun CategoryChip(
    category: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) ColorConstant.AccentOrange else ColorConstant.SurfaceDark
    val fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium

    Surface(
        color = backgroundColor,
        shape = CircleShape,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = category,
            color = ColorConstant.TextWhite,
            fontWeight = fontWeight,
            modifier = TextPaddingModifier,
            fontSize = Dimens.TextBody
        )
    }
}