package com.profinder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.profinder.R
import com.profinder.databinding.ActivityMainBinding
import com.profinder.ui.home.HomeFragment
import com.profinder.ui.search.SearchFragment
import com.profinder.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        
        // Set default fragment
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    binding.toolbar.title = getString(R.string.app_name)
                    true
                }
                R.id.nav_search -> {
                    loadFragment(SearchFragment())
                    binding.toolbar.title = getString(R.string.nav_search)
                    true
                }
                R.id.nav_bookings -> {
                    loadFragment(BookingsFragment())
                    binding.toolbar.title = getString(R.string.nav_bookings)
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    binding.toolbar.title = getString(R.string.nav_profile)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}

// Placeholder fragments - will be implemented later
class BookingsFragment : Fragment(R.layout.fragment_bookings)