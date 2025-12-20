package com.nafaskarya.muslimdaily.presentation.guestUser.part

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.SurfaceDark
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextGray
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextWhite
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.crossfade.CrossfadePlugin
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun GuestContentCard(
    item: ContentItem,
    screenWidth: Dp,
    onClick: (ContentItem) -> Unit
) {
    val cardWidth = screenWidth * 0.4f
    val imageRequest = remember(item.imageRes) { { item.imageRes } }

    Column(
        modifier = Modifier
            .width(cardWidth)
            .clickable { onClick(item) }
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            colors = CardDefaults.cardColors(containerColor = SurfaceDark)
        ) {
            CoilImage(
                imageModel = imageRequest,
                modifier = Modifier.fillMaxSize(),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                component = rememberImageComponent {
                    +CrossfadePlugin(duration = 250)
                    +ShimmerPlugin()
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            color = TextWhite,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = item.description,
            color = TextGray,
            fontSize = 13.sp,
            lineHeight = 18.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}