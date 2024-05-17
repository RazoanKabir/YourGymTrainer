package com.example.yourgymtrainer

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Food::class], version = 1)
abstract class FoodDatabase: RoomDatabase() {
    abstract val dao: FoodDao
}