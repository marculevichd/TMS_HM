package com.example.homework21_tms.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.homework21_tms.data.database.DataBaseExampleEntity


@Dao
interface DataBaseExampleDAO {

    @Insert
    fun insertDataBaseExampleEntity(dataBaseExampleEntity: DataBaseExampleEntity)

    @Query("SELECT * FROM dataBaseExampleEntity")
    fun getDataBaseExampleEntities(): List<DataBaseExampleEntity>

    @Query("SELECT(SELECT COUNT(*) FROM dataBaseExampleEntity) !=0")
    fun doesDataBaseExampleEntityExist(): Boolean

}