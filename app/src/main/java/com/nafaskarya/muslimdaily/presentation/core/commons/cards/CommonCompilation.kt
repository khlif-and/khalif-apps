package com.nafaskarya.muslimdaily.presentation.core.commons.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.commons.ImageOptimizer
import com.nafaskarya.muslimdaily.presentation.core.commons.models.CompilationCardModel
import com.nafaskarya.muslimdaily.presentation.core.commons.models.CompilationModelSubItem
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextWhite
import com.nafaskarya.muslimdaily.presentation.core.shared.card.CircleIconButton
import com.nafaskarya.muslimdaily.presentation.core.shared.card.GradientRoundedCard
import com.nafaskarya.muslimdaily.presentation.core.shared.card.PrimaryPillButton
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions
import kotlin.math.roundToInt

private val DefaultGradient = listOf(
    Color(0xFF3E2B2B),
    Color(0xFF1F1515)
)

@Composable
fun CommonCompilationCard(
    data: CompilationCardModel,
    dimen: WindowDimensions,
    onReadClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardWidth = dimen.width * 0.88f

    // Cache lambda untuk tombol like agar tidak alokasi ulang
    val onLikeClick = remember { {} }

    GradientRoundedCard(
        modifier = modifier
            .width(cardWidth)
            .padding(vertical = 8.dp)
            .graphicsLayer {
                // Hardware acceleration layer
                clip = true
                shape = RoundedCornerShape(16.dp)
            },
        cornerRadius = 16.dp,
        gradientColors = DefaultGradient
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CollageCoverImage(size = dimen.width * 0.28f)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = TextWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = dimen.getResponsiveTextSize(0.05f, min = 18f)
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = data.subtitle,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = TextWhite.copy(alpha = 0.7f),
                        fontWeight = FontWeight.Medium,
                        fontSize = dimen.getResponsiveTextSize(0.035f, min = 12f)
                    )
                )
                Text(
                    text = data.caption,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = TextWhite.copy(alpha = 0.5f),
                        fontSize = dimen.getResponsiveTextSize(0.03f, min = 11f)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Gunakan Column biasa karena items sedikit (3), LazyColumn di dalam LazyRow itu ILEGAL & BERAT
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            val takeAmount = 3
            val displayItems = remember(data.items) { data.items.take(takeAmount) }

            displayItems.forEach { item ->
                CompilationSubItemRow(dimen, item)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PrimaryPillButton(
                text = "Baca Sekarang",
                dimen = dimen,
                onClick = onReadClick
            )
            CircleIconButton(
                icon = Icons.Outlined.ThumbUp,
                contentDescription = "Like",
                onClick = onLikeClick
            )
        }
    }
}

@Composable
fun CompilationSubItemRow(dimen: WindowDimensions, item: CompilationModelSubItem) {
    val density = LocalDensity.current
    val imageSizePx = remember(dimen.width, density) {
        with(density) { (dimen.width * 0.12f).toPx().roundToInt() }
    }

    // DISINI PERBAIKANNYA: Pakai ImageOptimizer yang di-remember
    val imageRequest = ImageOptimizer.rememberBrutalImageRequest(
        model = item.imageUrl ?: R.drawable.img_onboarding,
        sizePx = imageSizePx
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = imageRequest,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimen.width * 0.12f)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = TextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimen.getResponsiveTextSize(0.038f, min = 14f)
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.subtitle,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = TextWhite.copy(alpha = 0.7f),
                    fontSize = dimen.getResponsiveTextSize(0.032f, min = 12f)
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More",
            tint = TextWhite.copy(alpha = 0.7f),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun CollageCoverImage(size: Dp) {
    // Kita optimasi agar 4 gambar menggunakan 1 request cache yang sama
    val density = LocalDensity.current
    val sizePx = remember(size, density) {
        with(density) { (size.value / 2).toInt() } // Bagi 2 karena collage grid
    }

    val imageRequest = ImageOptimizer.rememberBrutalImageRequest(
        model = R.drawable.img_onboarding,
        sizePx = sizePx
    )

    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column {
            Row(Modifier.weight(1f)) {
                CollageItem(imageRequest, Modifier.weight(1f))
                CollageItem(imageRequest, Modifier.weight(1f))
            }
            Row(Modifier.weight(1f)) {
                CollageItem(imageRequest, Modifier.weight(1f))
                CollageItem(imageRequest, Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CollageItem(request: ImageRequest, modifier: Modifier) {
    AsyncImage(
        model = request,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxHeight()
    )
}