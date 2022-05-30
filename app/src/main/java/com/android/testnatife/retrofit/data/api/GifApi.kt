package com.android.testnatife.retrofit.data.api

import androidx.annotation.IntRange
import com.android.testnatife.retrofit.data.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {

    @GET("gifs/search?api_key=YGHnKKBGSydS6nSt6WAoUcICWwmgCfvL&q=limit=25")
    fun getGifs(
        @Query("offset")@IntRange(from = 0) offset: Int = 0,
        @Query("lang")string: String = "en",
        @Query("rating")rating: String = "g"
        ): Call<Data>

    companion object {
        private val BASE_URL = "https://api.giphy.com/v1/"
        fun init(): GifApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GifApi::class.java)
        }
    }

}