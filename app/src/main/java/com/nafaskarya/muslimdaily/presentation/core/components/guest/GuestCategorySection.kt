package com.nafaskarya.muslimdaily.presentation.core.components.guest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@Composable
fun GuestCategorySection(dimen: WindowDimensions) {
    val categories = listOf("All", "Dakwah", "Kajian", "Podcast", "Murottal")
    val horizontalPadding = dimen.width * 0.05f

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = horizontalPadding),
        horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingSemiLarge)
    ) {
        items(categories) { category ->
            val isSelected = category == "All"
            val backgroundColor = if (isSelected) ColorConstant.AccentOrange else ColorConstant.SurfaceDark

            Surface(
                color = backgroundColor,
                shape = CircleShape,
                modifier = Modifier.clickable { }
            ) {
                Text(
                    text = category,
                    color = ColorConstant.TextWhite,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                    modifier = Modifier.padding(
                        horizontal = Dimens.PaddingXLarge,
                        vertical = Dimens.PaddingMedium
                    ),
                    fontSize = Dimens.TextBody
                )
            }
        }
    }
}