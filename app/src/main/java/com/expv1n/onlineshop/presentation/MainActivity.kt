package com.expv1n.onlineshop.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showBottomNavigationView() {
        binding.BottomNavigationView.visibility = View.VISIBLE
    }

    fun hideBottomNavigationView() {
        binding.BottomNavigationView.visibility = View.GONE
    }
}