package com.araskaplan.countries.domain.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.araskaplan.countries.databinding.FragmentDetailPageBinding
import com.araskaplan.countries.domain.util.Util.toWikiDataLink
import com.araskaplan.countries.domain.viewmodel.DetailPageViewModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPageFragment : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding
    private val viewModel: DetailPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailPageBinding.inflate(inflater)
        getDetails()
        observe()
        return binding.root
    }

    private fun getDetails(){
        arguments?.let {
            viewModel.fetchCountryDetails(DetailPageFragmentArgs.fromBundle(it).code)
        }
    }

    private fun observe(){
        viewModel.countryDetails.observe(viewLifecycleOwner){
            it?.let {
                binding.textviewDetailspageCountryname.text = it.name
                binding.textviewDetailspageCountrycode.text = it.code
                binding.buttonDetailspageMoreinfo.setOnClickListener { view->
                    val intent= Intent(Intent.ACTION_VIEW)
                    intent.data = it.wikiDataId.toWikiDataLink()
                    startActivity(intent)
                }


                // I have tried so many solutions, only to find out it was about ssl and svg
                GlideToVectorYou.init()
                    .with(requireContext())
                    .load(Uri.parse(it.flagImageUri.replace("http","https")),binding.imageView)
            }
        }
    }
}