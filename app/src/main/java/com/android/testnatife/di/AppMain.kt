package com.android.testnatife.di

import android.app.Application
import com.android.testnatife.di.components.AppComponent
import com.android.testnatife.di.components.DaggerAppComponent


class AppMain: Application() {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.builder()
            .build()
    }


}