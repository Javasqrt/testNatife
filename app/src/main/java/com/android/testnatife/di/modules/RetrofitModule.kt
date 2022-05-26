package com.android.testnatife.di.modules



import com.android.testnatife.retrofit.data.api.GifApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideGifApi(): GifApi{
        return GifApi.init()
    }

}