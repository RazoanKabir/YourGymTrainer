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
    suspend fun getAllFoodByAlphabet(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY proteinAmount DESC")
    suspend fun getFoodByProtein(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY fatAmount DESC")
    suspend fun getFoodByFat(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY caloriesAmount DESC")
    suspend fun getFoodByCalorie(): Flow<List<Food>>

    @Query("SELECT * FROM food ORDER BY carbsAmount DESC")
    suspend fun getFoodByCarb(): Flow<List<Food>>
}