package com.example.homework21_tms.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("workManagerEntity")
data class WorkManagerEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    val id: Int,
    @ColumnInfo
    val string: String
)