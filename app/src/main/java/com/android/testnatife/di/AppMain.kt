package com.android.testnatife.di

import android.app.Application
import com.android.testnatife.di.components.AppComponent
import com.android.testnatife.di.components.DaggerAppComponent


class AppMain: Application() {

    private val appComponent: AppComponent = DaggerAppComponent.builder().build()


    fun getAppComponent(): AppComponent{
        return appComponent
    }


}