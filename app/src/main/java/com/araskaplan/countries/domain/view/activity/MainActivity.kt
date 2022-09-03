package com.araskaplan.countries.domain.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.araskaplan.countries.R
import com.araskaplan.countries.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}