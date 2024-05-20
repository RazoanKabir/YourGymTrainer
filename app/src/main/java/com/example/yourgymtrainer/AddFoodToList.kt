package com.example.yourgymtrainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddFoodToList(state: FoodAddViewState, onEvent: (FoodEvent)->Unit, modifier: Modifier = Modifier) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(FoodEvent.HideFoodAddDialog)
        },
        title = { Text(text = "Add Food")},
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.foodName,
                    onValueChange = {
                        onEvent(FoodEvent.SetFoodName(it))
                    },
                    placeholder = {
                        Text(text = "Enter Food name")
                    }
                )
                TextField(
                    value = state.foodProtein.toString(),
                    onValueChange = {
                        onEvent(FoodEvent.SetFoodProtein(it))
                    },
                    placeholder = {
                        Text(text = "Enter Protein")
                    },

                )
                TextField(
                    value = state.foodCarbs.toString(),
                    onValueChange = {
                        onEvent(FoodEvent.SetFoodCarbs(it))
                    },
                    placeholder = {
                        Text(text = "Enter Carb")
                    }
                )
                TextField(
                    value = state.foodFat.toString(),
                    onValueChange = {
                        onEvent(FoodEvent.SetFoodFat(it))
                    },
                    placeholder = {
                        Text(text = "Enter Fat")
                    }
                )
                TextField(
                    value = state.foodCalories.toString(),
                    onValueChange = {
                        onEvent(FoodEvent.SetFoodCalories(it))
                    },
                    placeholder = {
                        Text(text = "Enter Calories")
                    }
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd) {
                androidx.compose.material3.Button(onClick = {
                    onEvent(FoodEvent.SaveNewFood)
                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}