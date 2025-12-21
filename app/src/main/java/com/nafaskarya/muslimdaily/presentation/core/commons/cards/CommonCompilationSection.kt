package com.nafaskarya.muslimdaily.presentation.core.commons.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nafaskarya.muslimdaily.presentation.core.commons.models.CompilationCardModel
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextWhite
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.WindowDimensions

@Composable
fun CommonCompilationSection(
    title: String,
    dataList: List<CompilationCardModel>,
    dimen: WindowDimensions,
    onItemClick: (CompilationCardModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimen.getResponsiveHeight(0.02f))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = dimen.getResponsiveTextSize(0.055f, min = 18f, max = 24f)
            ),
            modifier = Modifier.padding(
                horizontal = dimen.width * 0.05f,
                vertical = 12.dp
            )
        )

        Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.015f)))

        LazyRow(
            contentPadding = PaddingValues(horizontal = dimen.width * 0.05f),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = dataList,
                key = { it.title },
                contentType = { "compilation_card" }
            ) { item ->
                CommonCompilationCard(
                    data = item,
                    dimen = dimen,
                    onReadClick = { onItemClick(item) }
                )
            }
        }
    }
}