package com.example.yourgymtrainer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    val foodName: String,
    val foodAmountInGrams: String,
    val proteinAmount: String,
    val fatAmount: String,
    val caloriesAmount: String,
    val carbsAmount: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
