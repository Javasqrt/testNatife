package com.android.testnatife.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.testnatife.di.AppMain
import com.android.testnatife.recyclerview.Gif
import com.android.testnatife.retrofit.data.api.GifApi
import com.android.testnatife.retrofit.data.Data
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FirstScreenViewModel : ViewModel() {
    val currentGifList: MutableLiveData<ArrayList<Gif>> = MutableLiveData()
   val fullGifsList = ArrayList<Gif>()
    @Inject
    lateinit var gifApi: GifApi

    init {
        AppMain().getAppComponent().inject(this)
        val getGifsFromDI = gifApi.getGifs()
        viewModelScope.launch {
            main(getGifsFromDI)
        }.start()



    }
    suspend fun main(getGifsFromDI: Call<Data>){
        coroutineScope {
            launch {
                gifResponse(getGifsFromDI)
            }
        }
    }
    private fun gifResponse(gifsFromDI: Call<Data>) {

        gifsFromDI.enqueue(object: Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
               if(response.isSuccessful){
                   for(gif in response.body()?.data!!){
                       fullGifsList.add(gif)
                   }
                   currentGifList.postValue(fullGifsList)
               }
                Log.d("TESTLOG", "onResponse :  ${response.body()}")
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("Fail", "OnFailure : ${t.localizedMessage}")
            }

        })

    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}