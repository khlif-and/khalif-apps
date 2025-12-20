package com.nafaskarya.muslimdaily.presentation.guestUser.part

import androidx.compose.runtime.Immutable

@Immutable
data class ContentItem(
    val title: String,
    val description: String,
    val imageData: Any
)