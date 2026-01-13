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
fun ChoiceTopicPage(
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedItems by remember { mutableStateOf(setOf<String>()) }

    val topicList = listOf(
        "Fiqih",
        "Aqidah",
        "Akhlak",
        "Sirah",
        "Tafsir",
        "Hadist",
        "Muamalah",
        "Tasawuf",
        "Tarikh"
    )

    val title = buildAnnotatedString {
        withStyle(style = SpanStyle(color = White)) {
            append("Pilih 3 ")
        }
        withStyle(style = SpanStyle(color = OrangePrimary)) {
            append("Topik Favorite")
        }
        withStyle(style = SpanStyle(color = White)) {
            append("\nKamu.")
        }
    }

    ChoicePageTemplate(
        title = title,
        searchPlaceholder = "cari topik favorit disini",
        searchQuery = searchQuery,
        onSearchQueryChange = { searchQuery = it },
        items = topicList.filter { it.contains(searchQuery, ignoreCase = true) },
        selectedItems = selectedItems,
        maxSelection = 3,
        onItemClick = { topic ->
            if (selectedItems.contains(topic)) {
                selectedItems = selectedItems - topic
            } else {
                if (selectedItems.size < 3) {
                    selectedItems = selectedItems + topic
                }
            }
        },
        onContinueClick = onContinueClick,
        onSkipClick = onSkipClick
    ) { topic, isSelected ->
        ChoiceItem(
            name = topic,
            isSelected = isSelected,
            onClick = {
                if (selectedItems.contains(topic)) {
                    selectedItems = selectedItems - topic
                } else {
                    if (selectedItems.size < 3) {
                        selectedItems = selectedItems + topic
                    }
                }
            }
        )
    }
}
