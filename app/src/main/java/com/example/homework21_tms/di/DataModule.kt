package com.example.homework21_tms.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.homework21_tms.data.*
import com.example.homework21_tms.domain.auth.AuthRepository
import com.example.homework21_tms.domain.home.ItemRepository
import com.example.homework21_tms.domain.home.RetrofitExampleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(itemsRepositoryImpl: ItemRepositoryImpl): ItemRepository

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindRetrofitExampleRepository(retrofitExampleRepositoryImpl: RetrofitExampleRepositoryImpl): RetrofitExampleRepository


    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        private const val SP_KEY = "SP_KEY"


        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        fun provideSharedPreferences(
            context: Context
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(context.getSharedPreferences(SP_KEY, MODE_PRIVATE))
        }
    }
}