package com.araskaplan.countries.domain.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.araskaplan.countries.databinding.FragmentDetailPageBinding


class DetailCardFragment : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(inflater)
        return binding.root
    }

}