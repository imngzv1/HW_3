package com.example.hw_3

import android.app.Application
import androidx.room.Room
import com.example.hw_3.model.room.AppDatabase

class App :Application(){
    companion object{
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase=Room.databaseBuilder(applicationContext,AppDatabase::class.java,"love_file")
            .allowMainThreadQueries().build()
    }
}