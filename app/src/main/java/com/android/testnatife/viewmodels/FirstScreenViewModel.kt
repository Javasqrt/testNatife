package com.android.testnatife.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.testnatife.di.AppMain
import com.android.testnatife.recyclerview.Gif
import com.android.testnatife.recyclerview.GifsAdapter
import com.android.testnatife.retrofit.data.api.GifApi
import com.android.testnatife.retrofit.data.test.DataTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FirstScreenViewModel : ViewModel() {
    val liveData: MutableLiveData<ArrayList<Gif>> = MutableLiveData()
    private val list = ArrayList<Gif>()
    @Inject
    lateinit var gifApi: GifApi

    init {
        AppMain().getAppComponent().inject(this)
        val getGifsFromDI = gifApi.getGifs()

        gifResponse(getGifsFromDI)
    }

    private  fun gifResponse(gifsFromDI: Call<DataTest>) {

        gifsFromDI.enqueue(object: Callback<DataTest> {
            override fun onResponse(call: Call<DataTest>, response: Response<DataTest>) {
                for(gif in response.body()?.data!!){
                        list.add(gif)
                }
                liveData.postValue(list)
                Log.d("TESTLOG", "onResponse :  ${response.body()}")
            }

            override fun onFailure(call: Call<DataTest>, t: Throwable) {
                Log.d("Fail", "OnFailure : ${t.localizedMessage}")
            }

        })

    }


}