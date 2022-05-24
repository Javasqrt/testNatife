package com.android.testnatife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.android.testnatife.databinding.ActivityMainBinding
import com.android.testnatife.di.AppMain
import com.android.testnatife.di.component.AppComponent
import javax.inject.Inject


private lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppMain().appComponent.inject(this)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}