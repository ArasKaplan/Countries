package com.araskaplan.countries.domain.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.araskaplan.countries.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomePageBinding.inflate(inflater)
        return binding.root
    }

}