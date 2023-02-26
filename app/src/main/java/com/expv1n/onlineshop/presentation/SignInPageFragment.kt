package com.expv1n.onlineshop.presentation

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.FragmentSignInPageBinding


class SignInPageFragment : Fragment() {

    private var _binding: FragmentSignInPageBinding? = null
    private val binding: FragmentSignInPageBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}