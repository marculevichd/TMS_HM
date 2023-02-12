package com.example.homework21_tms

import android.app.Application
import com.example.homework21_tms.di.AppModule
import com.example.homework21_tms.di.component.AppComponent
import com.example.homework21_tms.di.component.DaggerAppComponent


class App : Application() {



    lateinit var appComponent: AppComponent

    fun provideAppComponent(): AppComponent {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }



}