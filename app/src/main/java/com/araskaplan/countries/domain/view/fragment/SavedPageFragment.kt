package com.araskaplan.countries.domain.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.araskaplan.countries.R
import com.araskaplan.countries.databinding.FragmentSavedPageBinding

class SavedPageFragment : Fragment() {
    private lateinit var binding:FragmentSavedPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedPageBinding.inflate(inflater)
        return binding.root
    }

}