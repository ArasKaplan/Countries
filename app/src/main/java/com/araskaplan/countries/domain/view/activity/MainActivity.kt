package com.araskaplan.countries.domain.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.araskaplan.countries.R
import com.araskaplan.countries.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareNavigation()
    }

    fun prepareNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView2.id) as NavHostFragment

        navController = navHostFragment.navController
        findViewById<BottomNavigationView>(binding.bottomNavigationView.id)
            .setupWithNavController(navController)

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homePageFragment, R.id.savedPageFragment))
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homefragmentmenuitem -> {
                    navController.navigate(R.id.homePageFragment)
                    true
                }
                R.id.savedfragmentmenuitem -> {
                    navController.navigate(R.id.savedPageFragment)
                    true
                }
                else -> false
            }
        }
    }
}