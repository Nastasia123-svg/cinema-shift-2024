package com.example.films.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shared.ui.theme.AppColors
import com.example.shared.ui.theme.OutLineButton
import com.example.shared.ui.theme.PrimaryButton
import kotlinx.coroutines.launch


@Composable
fun SelectPlaceScreen(modifier: Modifier = Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectPlaceScreenImpl(modifier: Modifier = Modifier) {

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
    val scope = rememberCoroutineScope()

    var selectedText by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize().padding(16.dp),) {

        Column {
            Text(text = "Ряд",  color = AppColors.TextSecondary)
            OutlinedTextField(
                value = selectedText,
                readOnly = true,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = AppColors.Gray
                ),
                modifier = Modifier.fillMaxWidth().clickable {
                    showBottomSheet = true
                },
                label = { Text("Выбрать ряд", color = AppColors.TextTertiary) },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "",
                        tint = Color.Gray)
                },
                onValueChange = {}
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Место",  color = AppColors.TextSecondary)
            OutlinedTextField(
                shape = RoundedCornerShape(16.dp),
                value = selectedText,
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = AppColors.Gray
                ),
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Выбрать место", color = AppColors.TextTertiary) },
                trailingIcon = {
                    Icon(imageVector = Icons.Filled.KeyboardArrowDown, contentDescription = "",
                        tint = Color.Gray)
                },
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(24.dp))
            OutLineButton(
                text = "Еще билет",
                clicked = {}
            )

        }

        PrimaryButton(text = "Продолжить", modifier = Modifier.align(Alignment.BottomCenter)) {
            
        }

    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            PlaceRowsComponent()
        }
    }
}

@Preview
@Composable
fun PlaceRowsComponent(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(
                bottom = 16.dp
            ), text = "Ряд",
            color = Color.Black,
            fontWeight = FontWeight(500)
        )
        LazyColumn {
            for (i in 1..6) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(

                            text = i.toString(),

                            )
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun SelectPlaceScreenPreview(modifier: Modifier = Modifier) {
    SelectPlaceScreenImpl()
}