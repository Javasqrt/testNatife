package com.android.testnatife.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.testnatife.R
import com.android.testnatife.databinding.FirstScreenFragmentBinding
import com.android.testnatife.recyclerview.Gif
import com.android.testnatife.recyclerview.GifsAdapter
import com.android.testnatife.viewmodels.FirstScreenViewModel
import java.util.*

class FirstScreenFragment : Fragment() {
    private lateinit var binding: FirstScreenFragmentBinding
    private lateinit var adapter: GifsAdapter
    private lateinit var arrayListSearch: ArrayList<Gif>
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
                adapter = GifsAdapter(it)

                edSearch.addTextChangedListener(object: TextWatcher{
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {

                    }

                    override fun afterTextChanged(s: Editable?) {

                        arrayListSearch =
                            ArrayList<Gif>()

                        for (item in it) {
                            if (item.name.lowercase().contains(s.toString().lowercase())) {
                                arrayListSearch.add(item)


                            } else if (item.name.uppercase().contains(s.toString().uppercase())) {

                                arrayListSearch.add(item)


                            }
                        }

                        adapter.getItemSearch(arrayListSearch)

                    }

                })

                adapter.setOnItemClickListener(object : GifsAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {

                        val bundle = Bundle()
                        bundle.putString("gifImageUrl",it[position].getUrl())
                        bundle.putString("gifName", it[position].name)
                        val navigation = Navigation.findNavController(binding.root)
                        val action = R.id.action_firstScreenFragment_to_secondScreenFragment
                        navigation.navigate(action,bundle)

                    }

                })



                recyclerItems.layoutManager = LinearLayoutManager(requireContext())
                recyclerItems.adapter = adapter

            }

        })



    }

}