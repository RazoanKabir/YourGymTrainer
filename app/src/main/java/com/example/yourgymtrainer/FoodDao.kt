package com.example.yourgymtrainer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Upsert
    suspend fun addFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Query("SELECT * FROM food ORDER BY foodName ASC")
    fun getAllFoodByAlphabet(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY proteinAmount DESC")
    fun getFoodByProtein(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY fatAmount DESC")
    fun getFoodByFat(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY caloriesAmount DESC")
    fun getFoodByCalorie(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY carbsAmount DESC")
    fun getFoodByCarb(): Flow<List<Food>>
}