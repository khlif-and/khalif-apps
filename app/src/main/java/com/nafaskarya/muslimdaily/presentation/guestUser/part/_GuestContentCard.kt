package com.nafaskarya.muslimdaily.presentation.guestUser.part

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.SurfaceDark
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextGray
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextWhite

@Composable
fun GuestContentCard(
    item: ContentItem,
    screenWidth: Dp,
    onClick: (ContentItem) -> Unit
) {
    val cardWidth = screenWidth * 0.42f

    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(end = 12.dp)
            .clickable(
                onClick = { onClick(item) },
                interactionSource = null,
                indication = null
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(12.dp))
                .background(SurfaceDark)
        ) {
            when (val data = item.imageData) {
                is Int -> {
                    Image(
                        painter = painterResource(id = data),
                        contentDescription = item.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                is String -> {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data)
                            .crossfade(true)
                            .allowHardware(true)
                            .diskCacheKey(data)
                            .memoryCacheKey(data)
                            .build(),
                        contentDescription = item.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = item.title,
            color = TextWhite,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = item.description,
            color = TextGray,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}