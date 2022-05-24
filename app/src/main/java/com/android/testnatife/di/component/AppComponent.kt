package com.android.testnatife.di.component

import com.android.testnatife.MainActivity
import com.android.testnatife.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class])
@Singleton
 interface AppComponent {
    //Activity
     fun inject(mainActivity: MainActivity)
}