package com.araskaplan.countries.domain.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.araskaplan.countries.databinding.FragmentDetailCardBinding


class DetailCardFragment : Fragment() {
    private lateinit var binding: FragmentDetailCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCardBinding.inflate(inflater)
        return binding.root
    }

}