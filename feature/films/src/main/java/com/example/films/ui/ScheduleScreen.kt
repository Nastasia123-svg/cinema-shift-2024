package com.example.films.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.films.models.ScheduleUi


@Composable
fun TimeTableScreen(modifier: Modifier = Modifier) {

}

@Composable
private fun TimeTableScreenImpl(
    modifier: Modifier = Modifier,
    scheduleUi: ScheduleUi = ScheduleUi.forPreview()
) {

    val selectedIndex by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = Modifier.background(color = Color.Gray)
    ) {

    }
}

@Preview
@Composable
private fun TimeTableScreenPreview(modifier: Modifier = Modifier) {
    TimeTableScreenImpl()
}