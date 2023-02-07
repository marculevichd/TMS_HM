package com.example.homework21_tms.domain.model


data class RetrofitExampleModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val addressStreet: String,
    val addressSuite: String,
    val addressCity: String,
    val addressZipcode: String,
    val geoLat: String,
    val geoLng: String,
    val phone: String,
    val website: String,
    val companyName: String,
    val companyCatchPhrase: String,
    val companyBs: String,
    val isSelected: Boolean
)
