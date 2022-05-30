package com.android.testnatife.viewmodels

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SecondScreenViewModel(application: Application, private val arguments: Bundle) : AndroidViewModel(application) {
    val liveDataStringName: MutableLiveData<String> = MutableLiveData()
    val liveDataStringUrl: MutableLiveData<String> = MutableLiveData()


    init {
        viewModelScope.launch {
            initName()
            initUrl()
        }.start()

    }

    private fun initUrl() {
        liveDataStringUrl.value = arguments.getString("gifImageUrl")
    }

    private fun initName() {
        liveDataStringName.value = arguments.getString("gifName")
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}