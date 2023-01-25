package com.example.homework21_tms.data

import com.example.homework21_tms.data.database.dao.DataBaseExampleDAO
import com.example.homework21_tms.data.database.DataBaseExampleEntity
import com.example.homework21_tms.domain.home.RetrofitExampleRepository
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitExampleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dataBaseExampleDAO: DataBaseExampleDAO
) :
    RetrofitExampleRepository {

    override suspend fun getDataFromJson() {
        return withContext(Dispatchers.IO) {

            if (dataBaseExampleDAO.doesDataBaseExampleEntityExist()) {

                val response = apiService.getDataFromJson()

                response.body()?.let {
                    it.map {
                        val dataBaseExampleEntity = DataBaseExampleEntity(
                            it.id,
                            it.name,
                            it.username,
                            it.email,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.address.geo.lat,
                            it.address.geo.lng,
                            it.phone,
                            it.website,
                            it.company.name,
                            it.company.catchPhrase,
                            it.company.bs
                        )
                        dataBaseExampleDAO.insertDataBaseExampleEntity(dataBaseExampleEntity)
                    }
                }
            }
        }
    }


    override suspend fun showDataFromDataBase(): List<RetrofitExampleModel> {
        return withContext(Dispatchers.IO) {
            val dataBaseExampleEntity = dataBaseExampleDAO.getDataBaseExampleEntities()
            dataBaseExampleEntity.map {
                RetrofitExampleModel(
                    it.idElem,
                    it.name,
                    it.username,
                    it.email,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.phone,
                    it.website,
                    it.companyName,
                    it.catchPhrase,
                    it.bs
                )
            }
        }
    }
}



