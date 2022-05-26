package com.android.testnatife.di.components

import com.android.testnatife.di.modules.RetrofitModule
import com.android.testnatife.fragments.FirstScreenFragment
import com.android.testnatife.fragments.SecondScreenFragment
import com.android.testnatife.viewmodels.FirstScreenViewModel
import com.android.testnatife.viewmodels.SecondScreenViewModel
import dagger.Component
import javax.inject.Singleton


@Component(modules = [RetrofitModule::class])
@Singleton
 interface AppComponent {
    //viewModel
     fun inject(firstScreenViewModel: FirstScreenViewModel)
     fun inject(secondScreenViewModel: SecondScreenViewModel)
}