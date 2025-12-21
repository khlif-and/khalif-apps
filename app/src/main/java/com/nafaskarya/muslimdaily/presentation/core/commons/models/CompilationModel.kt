package com.nafaskarya.muslimdaily.presentation.core.commons.models

import androidx.compose.runtime.Immutable

@Immutable
data class CompilationCardModel(
    val title: String,
    val subtitle: String,
    val caption: String,
    val items: List<CompilationModelSubItem>
)

@Immutable
data class CompilationModelSubItem(
    val title: String,
    val subtitle: String,
    val imageUrl: Any?
)