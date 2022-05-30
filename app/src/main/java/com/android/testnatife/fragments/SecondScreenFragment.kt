package com.android.testnatife.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.testnatife.R
import com.android.testnatife.databinding.SecondScreenFragmentBinding
import com.android.testnatife.viewmodels.SecondScreenViewModel
import com.android.testnatife.viewmodels.vmfactory.SecondFragmentFactory
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
        binding = SecondScreenFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this, SecondFragmentFactory(requireActivity().application,arguments))[SecondScreenViewModel::class.java]
        viewModel.liveDataStringUrl.observe(this, Observer {
            with(binding) {
                Glide.with(binding.root)
                    .asGif()
                    .load(it)
                    .error(R.drawable.error_icon)
                    .centerCrop()
                    .into(imagegif)
            }

        })
        viewModel.liveDataStringName.observe(this, Observer {
            with(binding){
                namegif.text = it
            }

        })

    }



}