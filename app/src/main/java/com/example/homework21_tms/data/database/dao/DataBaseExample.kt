package com.example.homework21_tms.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework21_tms.data.database.DataBaseExampleEntity


@Database(entities = [DataBaseExampleEntity::class], version = 1, exportSchema = false)
abstract class DataBaseExample : RoomDatabase() {

    abstract fun getDataBaseExampleDAO(): DataBaseExampleDAO

    companion object {

        private const val DATABASE_NAME = "response database"
        private var BD_INSTANCE: DataBaseExample? = null

        fun getDataBaseExampleInstance(context: Context): DataBaseExample {
            return BD_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    DataBaseExample::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { BD_INSTANCE = it }
        }
    }
}