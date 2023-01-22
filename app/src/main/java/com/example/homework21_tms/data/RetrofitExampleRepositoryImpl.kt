package com.example.homework21_tms.data

import com.example.homework21_tms.domain.home.RetrofitExampleRepository
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitExampleRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RetrofitExampleRepository {

    override suspend fun getDataFromJson(): List<RetrofitExampleModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getDataFromJson()

            response.body()?.let {
                it.map {
                    RetrofitExampleModel(
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
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }
}


