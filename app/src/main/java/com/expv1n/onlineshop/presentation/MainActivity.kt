package com.expv1n.onlineshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    launchFragment(Page1Fragment.getInstance(), Page1Fragment.NAME)
                    true
                }
                R.id.profile -> {
                    launchFragment(ProfileFragment.getInstance(), ProfileFragment.NAME)
                    true
                }
                else -> true
            }
        }
    }

    private fun launchFragment(fragment: Fragment, fragmentName: String) {
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    fun showBottomNavigationView() {
        binding.BottomNavigationView.visibility = View.VISIBLE
    }

    fun hideBottomNavigationView() {
        binding.BottomNavigationView.visibility = View.GONE
    }
}