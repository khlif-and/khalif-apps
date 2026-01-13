package com.khalifapps.muslimgenz.presentation.ui.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import com.khalifapps.muslimgenz.presentation.theme.AppBackground
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.SkipButton
import com.khalifapps.muslimgenz.presentation.ui.atoms.inputs.InputTextField
import com.khalifapps.muslimgenz.presentation.ui.atoms.text.HeadingAnnotated

@Composable
fun <T> ChoicePageTemplate(
    title: AnnotatedString,
    searchPlaceholder: String,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    items: List<T>,
    selectedItems: Set<T>,
    maxSelection: Int,
    onItemClick: (T) -> Unit,
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit,
    itemContent: @Composable (T, Boolean) -> Unit
) {
    Scaffold(
        containerColor = AppBackground,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppTheme.dimens.paddingMedium, vertical = AppTheme.dimens.paddingSmall),
                horizontalArrangement = Arrangement.End
            ) {
                SkipButton(onClick = onSkipClick)
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.paddingMedium)
            ) {
                PrimaryButton(
                    text = "Continue",
                    onClick = onContinueClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = AppTheme.dimens.paddingMedium)
        ) {
            HeadingAnnotated(text = title)

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))

            InputTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                label = searchPlaceholder,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.choiceGridVerticalSpacing),
                horizontalArrangement = Arrangement.spacedBy(AppTheme.dimens.choiceGridHorizontalSpacing),
                contentPadding = PaddingValues(bottom = AppTheme.dimens.paddingLarge)
            ) {
                items(items) { item ->
                    itemContent(item, selectedItems.contains(item))
                }
            }
        }
    }
}
