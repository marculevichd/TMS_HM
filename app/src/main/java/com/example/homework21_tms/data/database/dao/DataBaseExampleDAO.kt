package com.example.homework21_tms.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.homework21_tms.data.database.DataBaseExampleEntity
import com.example.homework21_tms.data.database.FaveEntity
import com.example.homework21_tms.domain.model.RetrofitExampleModel


@Dao
interface DataBaseExampleDAO {

    @Insert
    fun insertDataBaseExampleEntity(dataBaseExampleEntity: DataBaseExampleEntity)

    @Query("SELECT * FROM dataBaseExampleEntity")
    fun getDataBaseExampleEntities(): List<DataBaseExampleEntity>

    @Query("SELECT(SELECT COUNT(*) FROM dataBaseExampleEntity) !=0")
    fun doesDataBaseExampleEntityExist(): Boolean

    @Insert(onConflict = IGNORE)
    fun insertFaveEntity(faveEntity: FaveEntity)

    @Query("SELECT * FROM faveEntity")
    fun getFaveEntities(): List<FaveEntity>

    @Query("SELECT * FROM dataBaseExampleEntity WHERE idElem =:searchId")
    fun findItemEntityById(searchId: Int): DataBaseExampleEntity


}