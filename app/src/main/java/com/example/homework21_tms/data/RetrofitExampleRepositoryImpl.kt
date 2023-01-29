package com.example.homework21_tms.data

import com.example.homework21_tms.data.database.dao.DataBaseExampleDAO
import com.example.homework21_tms.data.database.DataBaseExampleEntity
import com.example.homework21_tms.data.database.FaveEntity
import com.example.homework21_tms.domain.home.RetrofitExampleRepository
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitExampleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dataBaseExampleDAO: DataBaseExampleDAO
) : RetrofitExampleRepository {

    override suspend fun getDataFromJson() {
        return withContext(Dispatchers.IO) {

            if (!dataBaseExampleDAO.doesDataBaseExampleEntityExist()) {

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

    override suspend fun favClicked(retrofitExampleModel: RetrofitExampleModel) {
        withContext(Dispatchers.IO) {
            dataBaseExampleDAO.insertFaveEntity(
                FaveEntity(
                    retrofitExampleModel.id,
                    retrofitExampleModel.name,
                    retrofitExampleModel.username,
                    retrofitExampleModel.email,
                    retrofitExampleModel.addressStreet,
                    retrofitExampleModel.addressSuite,
                    retrofitExampleModel.addressCity,
                    retrofitExampleModel.addressZipcode,
                    retrofitExampleModel.geoLat,
                    retrofitExampleModel.geoLng,
                    retrofitExampleModel.phone,
                    retrofitExampleModel.website,
                    retrofitExampleModel.companyName,
                    retrofitExampleModel.companyCatchPhrase,
                    retrofitExampleModel.companyBs
                )
            )
        }
    }


    override suspend fun getFavorites(): List<FaveModel> {
        return withContext(Dispatchers.IO) {
            val fave = dataBaseExampleDAO.getFaveEntities()
            fave.map {
                FaveModel(
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

    override suspend fun findItemById(searchText: Int): RetrofitExampleModel {
        return withContext(Dispatchers.IO) {
            val model = dataBaseExampleDAO.findItemEntityById(searchText)
            RetrofitExampleModel(
                model.idElem,
                model.name,
                model.username,
                model.email,
                model.street,
                model.suite,
                model.city,
                model.zipcode,
                model.lat,
                model.lng,
                model.phone,
                model.website,
                model.companyName,
                model.catchPhrase,
                model.bs
            )
        }
    }






}



