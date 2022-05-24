package com.android.testnatife.di.components

import com.android.testnatife.MainActivity
import com.android.testnatife.di.modules.GlideModule
import com.android.testnatife.di.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class, GlideModule::class])
@Singleton
 interface AppComponent {
    //Activity
     fun inject(mainActivity: MainActivity)
}