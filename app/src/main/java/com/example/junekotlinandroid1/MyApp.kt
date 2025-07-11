package com.example.junekotlinandroid1

import android.app.Application
import androidx.room.Room

class MyApp : Application(){

    companion object{
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my_db"
        ).build()
    }
}