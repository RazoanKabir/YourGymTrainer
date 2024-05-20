package com.example.yourgymtrainer

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DietScreen(state: FoodAddViewState, onEvent: (FoodEvent) -> Unit) {
    Scaffold(
        floatingActionButton = {
            Column(
               modifier = Modifier.padding(8.dp)
            ) {
                FloatingActionButton(onClick = {
                    onEvent(FoodEvent.ShowFoodFilterDialog)
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.sort),
                        contentDescription = "Sort food dialog"
                    )
                }

                FloatingActionButton(onClick = {
                    onEvent(FoodEvent.ShowFoodAddDialog)
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add your food"
                    )
                }
            }

        }
    ) {
        paddingValues ->
        if(state.isAddingFood) {
            AddFoodToList(state = state, onEvent = onEvent)
        }
        if(state.isShowingFilter) {
            FilterFoodDialog(state = state, onEvent = onEvent)
        }
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.foods) {food ->
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                       Text(text = food.foodName, fontSize = 20.sp)
                       Text(text = "P = ${food.proteinAmount}, C = ${food.carbsAmount}, F = ${food.fatAmount}, cal = ${food.caloriesAmount}",
                           fontSize = 14.sp)
                    }
                }
            }
        }
    }
}