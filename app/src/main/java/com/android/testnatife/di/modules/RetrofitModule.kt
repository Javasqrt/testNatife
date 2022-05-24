package com.android.testnatife.di.modules



import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit? {

        return null
    }
}