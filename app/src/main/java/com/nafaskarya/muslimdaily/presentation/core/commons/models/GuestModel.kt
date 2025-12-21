package com.nafaskarya.muslimdaily.presentation.core.commons.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ContentItem(
    @StringRes val title: Int,       // Ubah dari String ke Int
    @StringRes val description: Int, // Ubah dari String ke Int
    @DrawableRes val imageData: Int
)