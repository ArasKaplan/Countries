package com.araskaplan.countries.domain.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.araskaplan.countries.databinding.FragmentHomePageBinding
import com.araskaplan.countries.domain.view.adapter.CountryAdapter
import com.araskaplan.countries.domain.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var adapter: CountryAdapter
    private val viewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePageBinding.inflate(inflater)
        initializeViews()
        viewModel.fetchCountries()
        observe()
        return binding.root
    }


    fun initializeViews() {
        binding.recvHomepage.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = CountryAdapter(this::recvOnclick,this::starOnClick)
        binding.recvHomepage.adapter = adapter
    }

    private fun observe() {
        viewModel.countryList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun recvOnclick(position: Int) {
        val toDetailsFragment =
            HomePageFragmentDirections
                .actionHomePageFragmentToDetailCardFragment(adapter.currentList[position].countryCode)
        findNavController().navigate(toDetailsFragment)
    }
    private fun starOnClick(position: Int){
        viewModel.insertCountry(adapter.currentList[position].countryCode)
    }
}