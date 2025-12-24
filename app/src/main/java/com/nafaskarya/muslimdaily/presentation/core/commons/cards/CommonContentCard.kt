package com.nafaskarya.muslimdaily.presentation.core.commons.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.nafaskarya.muslimdaily.presentation.core.commons.ImageOptimizer
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import kotlin.math.roundToInt

@Composable
fun CommonContentCard(
    title: String,
    description: String,
    image: Any?,
    dimen: WindowDimensions,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val cardWidthDp = dimen.width * 0.4f

    val sizeInPx = remember(cardWidthDp, density) {
        with(density) { cardWidthDp.toPx().roundToInt() }
    }

    Column(
        modifier = modifier
            .width(cardWidthDp)
            .padding(end = Dimens.PaddingMedium)
            .graphicsLayer {
                // OPTIMASI: Render sebagai layer tekstur terpisah
                // Ini mencegah redraw ulang parent saat ripple effect terjadi
                clip = false
            }
            .clickable(onClick = onClick)
    ) {
        Card(
            shape = RoundedCornerShape(Dimens.RadiusSmall),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            colors = CardDefaults.cardColors(containerColor = ColorConstant.SurfaceDark)
        ) {
            val optimizedRequest = ImageOptimizer.rememberBrutalImageRequest(
                model = image,
                sizePx = sizeInPx
            )

            AsyncImage(
                model = optimizedRequest,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))

        // Text optimization: Text juga bisa berat, pastikan modifier seminimal mungkin
        Text(
            text = title,
            color = ColorConstant.TextWhite,
            fontSize = Dimens.TextBody,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(Dimens.PaddingExtraSmall))

        Text(
            text = description,
            color = ColorConstant.TextGray,
            fontSize = Dimens.TextSmall,
            lineHeight = Dimens.LineHeightSmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}