package com.android.testnatife.viewmodels.vmfactory

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.testnatife.viewmodels.SecondScreenViewModel

class SecondFragmentFactory(val application: Application,val arguments: Bundle?): ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return arguments?.let { SecondScreenViewModel(application, it) } as T
    }
}