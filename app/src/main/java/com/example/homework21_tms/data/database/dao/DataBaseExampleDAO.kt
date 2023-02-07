package com.example.homework21_tms.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.homework21_tms.data.database.DataBaseExampleEntity
import com.example.homework21_tms.data.database.FaveEntity
import com.example.homework21_tms.data.database.WorkManagerEntity
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.flow.Flow


@Dao
interface DataBaseExampleDAO {

    @Insert
    fun insertDataBaseExampleEntity(dataBaseExampleEntity: DataBaseExampleEntity)

    @Query("SELECT * FROM dataBaseExampleEntity")
    fun getDataBaseExampleEntities(): Flow<List<DataBaseExampleEntity>>

    @Query("SELECT(SELECT COUNT(*) FROM dataBaseExampleEntity) !=0")
    fun doesDataBaseExampleEntityExist(): Boolean

    @Insert(onConflict = IGNORE)
    fun insertFaveEntity(faveEntity: FaveEntity)

    @Query("SELECT * FROM faveEntity")
    fun getFaveEntities(): Flow<List<FaveEntity>>

    @Query("SELECT * FROM dataBaseExampleEntity WHERE idElem =:searchId")
    fun findItemEntityById(searchId: Int): DataBaseExampleEntity

    @Query("DELETE FROM dataBaseExampleEntity WHERE idElem =:searchId")
    fun deleteItemFromDataBaseExampleEntity(searchId: Int)

    @Query("DELETE FROM faveEntity WHERE idElem =:searchId")
    fun deleteItemFromFaveEntity(searchId: Int)

    @Query("UPDATE dataBaseExampleEntity SET isSelected =:newIsSelected WHERE idElem =:idElem")
    fun updateStatusSelectedInItem(idElem: Int, newIsSelected: Boolean)






    // funs for workManager
    @Insert
    fun insertStringWorkManagerEntity(workManagerEntity: WorkManagerEntity)

    @Query("SELECT * FROM workManagerEntity")
    fun getStringFromWorkManagerEntity(): WorkManagerEntity


}