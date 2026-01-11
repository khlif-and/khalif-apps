package com.khalifapps.muslimgenz.presentation.ui.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.khalifapps.muslimgenz.presentation.theme.FormBackground
import com.khalifapps.muslimgenz.presentation.theme.White
import com.khalifapps.muslimgenz.presentation.ui.atoms.InputTextField

@Composable
fun PhoneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        // Country Code Box
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp) // Match InputTextField internal padding
                .width(80.dp)
                .height(56.dp) // Match default height of OutlinedTextField
                .background(FormBackground, RectangleShape)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Placeholder for flag (circle shape normally)
                Box(modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .background(Color.Red, RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "+62", color = White)
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Phone Input
        Box(modifier = Modifier.weight(1f)) {
            InputTextField(
                value = value,
                onValueChange = { if (it.all { char -> char.isDigit() }) onValueChange(it) },
                label = "Phone Number",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                shape = RectangleShape
            )
        }
    }
}
