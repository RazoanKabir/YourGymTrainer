package com.example.yourgymtrainer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FilterFoodDialog(state: FoodAddViewState, onEvent: (FoodEvent)->Unit, modifier: Modifier = Modifier) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(FoodEvent.HideFoodFilterDialog)
        },
        title = { Text(text = "Filter") },
        text = {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column {
                        FoodSortType.values().forEach {sortType->
                            Row(
                                modifier = Modifier.clickable {
                                    onEvent(FoodEvent.SortFoods(sortType))
                                },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = state.sortType == sortType,
                                    onClick = {
                                        onEvent(FoodEvent.SortFoods(sortType))
                                    })
                                Text(text = sortType.name)
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {}
    )
}