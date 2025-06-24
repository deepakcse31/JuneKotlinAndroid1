package com.example.junekotlinandroid1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_info")
data class StudentInfoData(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    val firstName: String?,
   val lastName: String?,
     val enrollment: String
)
