package com.example.yourgymtrainer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    val foodName: String,
    val foodAmount: String,
    val proteinAmount: Float,
    val fatAmount: Float,
    val caloriesAmount: Float,
    val carbsAmount: Float,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
