package com.khalifapps.muslimgenz.presentation.ui.pages.choice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalifapps.muslimgenz.presentation.theme.AppTheme
import com.khalifapps.muslimgenz.presentation.theme.AppBackground
import com.khalifapps.muslimgenz.presentation.theme.OrangePrimary
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.PrimaryButton
import com.khalifapps.muslimgenz.presentation.ui.atoms.buttons.SkipButton
import com.khalifapps.muslimgenz.presentation.ui.atoms.inputs.InputTextField
import com.khalifapps.muslimgenz.presentation.ui.molecules.choice.UstadzItem

@Composable
fun ChoicePage(
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedUstadz by remember { mutableStateOf(setOf<String>()) }

    val ustadzList = listOf(
        "Ust. Hanan\nAttaki",
        "Ust. Khalid\nBasalamah",
        "Ust. Abdul\nSomad",
        "Ust. Adi\nHidayat",
        "Ust. Felix\nSiauw",
        "Ust. Das'ad\nLatif",
        "Ust. Syafiq\nRiza Basalamah",
        "Ust. Firanda\nAndirja",
        "Ust. Oemar\nMita"
    )

    Scaffold(
        containerColor = AppBackground,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppTheme.dimens.paddingMedium, vertical = AppTheme.dimens.paddingSmall),
                horizontalArrangement = Arrangement.End
            ) {
                SkipButton(onClick = onSkipClick)
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppTheme.dimens.paddingMedium)
            ) {
                PrimaryButton(
                    text = "Continue",
                    onClick = onContinueClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = AppTheme.dimens.paddingMedium)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = White)) {
                        append("Pilih 3 ")
                    }
                    withStyle(style = SpanStyle(color = OrangePrimary)) {
                        append("Ustadz Favorite")
                    }
                    withStyle(style = SpanStyle(color = White)) {
                        append("\nKamu.")
                    }
                },
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingMedium))

            InputTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = "cari ustadz favorit disini",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
            )

            Spacer(modifier = Modifier.height(AppTheme.dimens.paddingLarge))

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp)
            ) {
                items(ustadzList.filter { it.contains(searchQuery, ignoreCase = true) }) { name ->
                    UstadzItem(
                        name = name,
                        isSelected = selectedUstadz.contains(name),
                        onClick = {
                            if (selectedUstadz.contains(name)) {
                                selectedUstadz = selectedUstadz - name
                            } else {
                                if (selectedUstadz.size < 3) {
                                    selectedUstadz = selectedUstadz + name
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
