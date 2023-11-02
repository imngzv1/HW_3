package com.example.hw_3.model.room

import androidx.room.Database;
import androidx.room.RoomDatabase
import com.example.hw_3.model.LoveModel

@Database(version = 1, entities = [LoveModel::class])
abstract class AppDatabase:RoomDatabase() {
    abstract fun getLoveDao(): LoveDao
}