package com.android.testnatife.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class GlideModule {

    @Provides
    @Singleton
    fun provideGlide() : Retrofit? {

        return null
    }


}