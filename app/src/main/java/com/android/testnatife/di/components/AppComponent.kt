package com.android.testnatife.di.components

import com.android.testnatife.di.modules.RetrofitModule
import com.android.testnatife.viewmodels.FirstScreenViewModel
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class])
@Singleton
 interface AppComponent {
    //viewModel
     fun inject(firstScreenViewModel: FirstScreenViewModel)
}