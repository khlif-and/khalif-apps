package com.khalifapps.muslimgenz.presentation.ui.pages.choice

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.molecules.choice.ChoiceItem
import com.khalifapps.muslimgenz.presentation.ui.templates.ChoicePageTemplate

@Composable
fun ChoiceUstadzPage(
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedItems by remember { mutableStateOf(setOf<String>()) }

    val ustadzList = listOf(
        "Ust. Hanan\nAttaki",
        "Ust. Khalid\nBasalamah",
        "Ust. Abdul\nSomad",
        "Ust. Adi\nHidayat",
        "Ust. Felix\nSiauw",
        "Ust. Das'ad\nLatif",
        "Ust. Syafiq\nRiza Basalamah",
        "Ust. Firanda\nAndirja",
        "Ust. Oemar\nMita"
    )

    val title = buildAnnotatedString {
        withStyle(style = SpanStyle(color = White)) {
            append("Pilih 3 ")
        }
        withStyle(style = SpanStyle(color = OrangePrimary)) {
            append("Ustadz Favorite")
        }
        withStyle(style = SpanStyle(color = White)) {
            append("\nKamu.")
        }
    }

    ChoicePageTemplate(
        title = title,
        searchPlaceholder = "cari ustadz favorit disini",
        searchQuery = searchQuery,
        onSearchQueryChange = { searchQuery = it },
        items = ustadzList.filter { it.contains(searchQuery, ignoreCase = true) },
        selectedItems = selectedItems,
        maxSelection = 3,
        onItemClick = { name ->
            if (selectedItems.contains(name)) {
                selectedItems = selectedItems - name
            } else {
                if (selectedItems.size < 3) {
                    selectedItems = selectedItems + name
                }
            }
        },
        onContinueClick = onContinueClick,
        onSkipClick = onSkipClick
    ) { name, isSelected ->
        ChoiceItem(
            name = name,
            isSelected = isSelected,
            onClick = {
                if (selectedItems.contains(name)) {
                    selectedItems = selectedItems - name
                } else {
                    if (selectedItems.size < 3) {
                        selectedItems = selectedItems + name
                    }
                }
            }
        )
    }
}
