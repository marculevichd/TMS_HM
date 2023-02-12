package com.example.homework21_tms.di

import android.content.Context
import com.example.homework21_tms.data.database.dao.DataBaseExample
import com.example.homework21_tms.data.database.dao.DataBaseExampleDAO
import dagger.Module
import dagger.Provides


@Module
class DataBaseModule {

    @Provides
    fun provideDataBaseExample(context: Context): DataBaseExample {
        return DataBaseExample.getDataBaseExampleInstance(context)
    }

    @Provides
    fun provideDataBaseExampleDAO(dataBaseExample: DataBaseExample): DataBaseExampleDAO{
        return dataBaseExample.getDataBaseExampleDAO()
    }
}