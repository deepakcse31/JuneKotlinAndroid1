package com.example.junekotlinandroid1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StudentInfoData::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun studentInfoDao(): StudentInfoDao
}