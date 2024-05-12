package com.example.yourgymtrainer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    val foodName: String,
    val proteinAmount: Int,
    val fatAmount: Int,
    val caloriesAmount: Int,
    val carbsAmount: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
