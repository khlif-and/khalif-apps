package com.nafaskarya.muslimdaily.presentation.core.commons

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale

object ImageOptimizer {

    @Composable
    // HAPUS @ReadOnlyComposable KARENA KITA BUTUH 'remember'
    fun rememberBrutalImageRequest(
        model: Any?,
        sizePx: Int,
        useRgb565: Boolean = true
    ): ImageRequest {
        val context = LocalContext.current

        // 'remember' menyimpan hasil build request.
        // Jika model/size tidak berubah, object lama dipakai lagi (Zero Allocation).
        return remember(model, sizePx, useRgb565) {
            ImageRequest.Builder(context)
                .data(model)
                .size(sizePx)
                .scale(Scale.FILL)
                .precision(Precision.EXACT)
                .apply {
                    if (useRgb565) bitmapConfig(Bitmap.Config.RGB_565)
                }
                .allowHardware(true)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .networkCachePolicy(CachePolicy.ENABLED)
                .crossfade(false) // Penting untuk list: Matikan crossfade biar instant
                .build()
        }
    }
}