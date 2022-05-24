package com.android.testnatife.di

import android.app.Application
import com.android.testnatife.di.component.AppComponent
import com.android.testnatife.di.component.DaggerAppComponent


class AppMain: Application() {
         lateinit var appComponent: AppComponent



    override fun onCreate() {
        super.onCreate()
         appComponent = DaggerAppComponent.builder()
            .build()
    }


}