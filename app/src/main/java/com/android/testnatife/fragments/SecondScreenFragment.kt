package com.android.testnatife.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.testnatife.R
import com.android.testnatife.databinding.SecondScreenFragmentBinding
import com.android.testnatife.viewmodels.SecondScreenViewModel
import com.bumptech.glide.Glide

class SecondScreenFragment : Fragment() {
    private lateinit var binding: SecondScreenFragmentBinding
    private lateinit var gifImageUrl: String
    private lateinit var gifName: String


    private lateinit var viewModel: SecondScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gifImageUrl = arguments?.getString("gifImageUrl").toString()
        gifName = arguments?.getString("gifName").toString()
        binding = SecondScreenFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this)[SecondScreenViewModel::class.java]
        with(binding){
            Glide.with(binding.root)
                .asGif()
                .load(gifImageUrl)
                .error(R.drawable.error_icon)
                .centerCrop()
                .into(imagegif)
            namegif.text = gifName
        }
     /*   viewModel.liveData.observe(this, Observer {
            with(binding){
                Glide.with(binding.root)
                    .asGif()
                    .load(it.images)
                    .error(R.drawable.error_icon)
                    .centerCrop()
                    .into(imagegif)
                namegif.text = it.name
            }
        })*/

    }



}