package com.example.shared.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    clicked: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .then(modifier),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.Primary
        ),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            clicked()
        }) {
        Text(text = text)
    }
}

@Preview
@Composable
fun OutLineButton(
    modifier: Modifier = Modifier,
    text: String = "Click",
    clicked: () -> Unit = {}
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .border(width = 1.dp, color = AppColors.LightGray, shape = RoundedCornerShape(16.dp))
            .then(modifier),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            clicked()
        }) {
        Text(text = text, color = AppColors.TextSecondary)
    }
}