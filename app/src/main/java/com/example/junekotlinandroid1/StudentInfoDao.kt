package com.example.junekotlinandroid1

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface StudentInfoDao {
    @Insert
    suspend fun insert(studentInfoData: StudentInfoData)
}