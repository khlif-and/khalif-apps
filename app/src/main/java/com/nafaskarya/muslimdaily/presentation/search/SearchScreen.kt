package com.nafaskarya.muslimdaily.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant
import com.nafaskarya.muslimdaily.presentation.core.constant.Dimens
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions

@Composable
fun SearchScreen(
    navController: NavController
) {
    val dimen = rememberWindowDimensions()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = Dimens.PaddingLarge)
                .padding(bottom = 24.dp)
        ) {
            TopSearchBar()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(bottom = Dimens.PaddingLarge)
        ) {

            Box(modifier = Modifier.padding(horizontal = Dimens.PaddingLarge)) {
                SectionTitle(stringResource(id = R.string.search_history_title))
            }

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.02f)))
            ContentRow()

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))

            Box(modifier = Modifier.padding(horizontal = Dimens.PaddingLarge)) {
                SectionTitle(stringResource(id = R.string.search_dakwah_title))
            }

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.02f)))
            ContentRow()

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))

            Box(modifier = Modifier.padding(horizontal = Dimens.PaddingLarge)) {
                SectionTitle("Browser Fav Ustd")
            }

            Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.02f)))

            Box(modifier = Modifier.padding(horizontal = Dimens.PaddingLarge)) {
                FavUstadzGrid()
            }
        }
    }
}

@Composable
fun FavUstadzGrid() {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)
        ) {
            UstadzCard(
                name = "Ust. Hanan\nAttaki",
                backgroundColor = Color(0xFF1ABC9C),
                modifier = Modifier.weight(1f)
            )
            UstadzCard(
                name = "Ust. Khalid\nBasalamah",
                backgroundColor = Color(0xFF5DADE2),
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingMedium)
        ) {
            UstadzCard(
                name = "Ust. Hanan\nAttaki",
                backgroundColor = Color(0xFF1565C0),
                modifier = Modifier.weight(1f)
            )
            UstadzCard(
                name = "Ust. Hanan\nAttaki",
                backgroundColor = Color(0xFF1565C0),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun UstadzCard(
    name: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1.6f)
            .clip(RoundedCornerShape(Dimens.RadiusMedium))
            .background(backgroundColor)
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = Color.White.copy(alpha = 0.2f),
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        )

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(64.dp)
                .padding(end = 8.dp)
        )

        Text(
            text = name,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 12.dp, bottom = 12.dp)
        )
    }
}

@Composable
fun TopSearchBar() {
    val dimen = rememberWindowDimensions()
    val placeholderSize = dimen.getResponsiveTextSize(0.035f, min = 12f, max = 15f)

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(ColorConstant.TextWhite)
        )

        Spacer(modifier = Modifier.width(Dimens.PaddingSemiLarge))

        Box(
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .clip(RoundedCornerShape(Dimens.RadiusMedium))
                .background(ColorConstant.TextWhite)
                .padding(horizontal = Dimens.PaddingSemiLarge),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = ColorConstant.TextGray,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(Dimens.PaddingMedium))
                Text(
                    text = stringResource(id = R.string.search_placeholder),
                    style = TextStyle(
                        color = ColorConstant.TextGray,
                        fontSize = placeholderSize
                    )
                )
            }
        }

        Spacer(modifier = Modifier.width(Dimens.PaddingSemiLarge))

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null,
            tint = ColorConstant.TextWhite,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    val dimen = rememberWindowDimensions()
    val titleSize = dimen.getResponsiveTextSize(0.045f, min = 16f, max = 22f)

    Text(
        text = title,
        style = TextStyle(
            color = ColorConstant.TextWhite,
            fontSize = titleSize,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun ContentRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Dimens.PaddingLarge),
        contentPadding = PaddingValues(horizontal = Dimens.PaddingLarge)
    ) {
        items(5) {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(220.dp)
                    .clip(RoundedCornerShape(Dimens.RadiusLarge))
                    .background(Color(0xFFD9D9D9))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}