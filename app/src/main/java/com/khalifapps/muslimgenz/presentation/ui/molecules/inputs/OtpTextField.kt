package com.khalifapps.muslimgenz.presentation.ui.molecules.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.khalifapps.muslimgenz.presentation.theme.FormBackground
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.theme.AppTheme

@Composable
fun OtpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    length: Int = 5,
    modifier: Modifier = Modifier
) {
    BasicTextField(
        value = value,
        onValueChange = {
            if (it.length <= length && it.all { char -> char.isDigit() }) {
                onValueChange(it)
            }
        },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.Center
            ) {
                 // The actual UI
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(length) { index ->
                        val char = when {
                            index >= value.length -> ""
                            else -> value[index].toString()
                        }
                        val isFocused = value.length == index
                        
                            
                        Box(
                            modifier = Modifier
                                .width(AppTheme.dimens.otpBoxSize)
                                .height(AppTheme.dimens.otpBoxSize)
                                .background(FormBackground)
                                .then(
                                    if (isFocused) Modifier.border(1.dp, Color.Gray) else Modifier
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = char,
                                color = White,
                                style = MaterialTheme.typography.headlineSmall,
                                textAlign = TextAlign.Center
                            )
                        }
                        if (index < length - 1) {
                            androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(AppTheme.dimens.otpSpacer))
                        }
                    }
                }
                // Hidden input field to capture focus and input events
                // We keep it in the composition tree but visually hidden
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .alpha(0f)
                ) {
                    innerTextField()
                }
            }
        },
        cursorBrush = SolidColor(Color.Transparent) // Hide cursor
    )
}
