package com.nafaskarya.muslimdaily.presentation.guestUser.part



import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Surface

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp

import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant



@Composable

fun GuestCategorySection(dimen: WindowDimensions) {

    val categories = listOf("All", "Dakwah", "Kajian", "Podcast", "Murottal")

    val horizontalPadding = dimen.width * 0.05f



    LazyRow(

        modifier = Modifier.fillMaxWidth(),

        contentPadding = PaddingValues(horizontal = horizontalPadding),

        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {

        items(categories) { category ->

            val isSelected = category == "All"

            val backgroundColor = if (isSelected) ColorConstant.AccentOrange else ColorConstant.SurfaceDark



            Surface(

                color = backgroundColor,

                shape = RoundedCornerShape(50),

                modifier = Modifier.clickable { }

            ) {

                Text(

                    text = category,

                    color = ColorConstant.TextWhite,

                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,

                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),

                    fontSize = 14.sp

                )

            }

        }

    }

}

