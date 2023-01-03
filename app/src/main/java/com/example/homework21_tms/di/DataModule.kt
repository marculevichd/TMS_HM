package com.example.homework21_tms.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.homework21_tms.data.AuthRepositoryImpl
import com.example.homework21_tms.data.ItemRepositoryImpl
import com.example.homework21_tms.data.SharedPreferencesHelper
import com.example.homework21_tms.domain.auth.AuthRepository
import com.example.homework21_tms.domain.home.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(itemsRepositoryImpl: ItemRepositoryImpl): ItemRepository

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    companion object {

        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(context.getSharedPreferences(SP_KEY, MODE_PRIVATE))
        }
    }
}