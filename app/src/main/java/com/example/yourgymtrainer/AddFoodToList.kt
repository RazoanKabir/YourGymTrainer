package com.example.yourgymtrainer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column {
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
                            value = state.foodAmountInGrams,
                            onValueChange = {
                                onEvent(FoodEvent.SetFoodAmountInGrams(it))
                            },
                            placeholder = {
                                Text(text = "Enter Food Amount in grams/pcs")
                            }
                        )
                        TextField(
                            value = state.foodProtein,
                            onValueChange = {
                                onEvent(FoodEvent.SetFoodProtein(it))
                            },
                            placeholder = {
                                Text(text = "Enter Protein")
                            },

                            )
                        TextField(
                            value = state.foodCarbs,
                            onValueChange = {
                                onEvent(FoodEvent.SetFoodCarbs(it))
                            },
                            placeholder = {
                                Text(text = "Enter Carb")
                            }
                        )
                        TextField(
                            value = state.foodFat,
                            onValueChange = {
                                onEvent(FoodEvent.SetFoodFat(it))
                            },
                            placeholder = {
                                Text(text = "Enter Fat")
                            }
                        )
                        TextField(
                            value = state.foodCalories,
                            onValueChange = {
                                onEvent(FoodEvent.SetFoodCalories(it))
                            },
                            placeholder = {
                                Text(text = "Enter Calories")
                            }
                        )
                    }
                }
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