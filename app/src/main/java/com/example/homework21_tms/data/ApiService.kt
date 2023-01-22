package com.example.homework21_tms.data

import retrofit2.Response
import retrofit2.http.GET

interface  ApiService {

    @GET("/users")
    suspend fun getDataFromJson(): Response<List<DataResponse>>

}