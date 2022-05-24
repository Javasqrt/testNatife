package com.android.testnatife.di.components

import com.android.testnatife.di.modules.GlideModule
import com.android.testnatife.di.modules.RetrofitModule
import com.android.testnatife.fragments.FirstScreenFragment
import com.android.testnatife.fragments.SecondScreenFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class, GlideModule::class])
@Singleton
 interface AppComponent {
    //Fragments
     fun inject(firstScreenFragment: FirstScreenFragment)
     fun inject(secondScreenFragment: SecondScreenFragment)
}