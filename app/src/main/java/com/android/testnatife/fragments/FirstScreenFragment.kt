package com.android.testnatife.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.testnatife.databinding.FirstScreenFragmentBinding
import com.android.testnatife.di.AppMain
import com.android.testnatife.viewmodels.FirstScreenViewModel
import com.android.testnatife.recyclerview.Gif
import com.android.testnatife.recyclerview.GifsAdapter
import com.android.testnatife.retrofit.data.api.GifApi
import com.android.testnatife.retrofit.data.test.DataTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class FirstScreenFragment : Fragment() {
    private lateinit var binding: FirstScreenFragmentBinding


    private lateinit var viewModel: FirstScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FirstScreenFragmentBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FirstScreenViewModel::class.java]
        viewModel.liveData.observe(this, Observer {
            binding.apply {
                recyclerItems.layoutManager = LinearLayoutManager(requireContext())
                recyclerItems.adapter = GifsAdapter(it)

            }

        })



    }

}