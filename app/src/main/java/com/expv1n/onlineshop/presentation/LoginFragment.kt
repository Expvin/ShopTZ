package com.expv1n.onlineshop.presentation

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.expv1n.onlineshop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        checkPasswordVisible()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun checkPasswordVisible() {
        var isVisible = true
        binding.checkPasswordImageView.setOnClickListener {
            if (isVisible) {
                binding.welcomePasswordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                isVisible = false
                Toast.makeText(requireActivity(), "IF", Toast.LENGTH_SHORT).show()
            } else {
                binding.welcomePasswordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                isVisible = true
                Toast.makeText(requireActivity(), "ELSE", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

        const val NAME = "LoginFragment"

        fun getInstance() = LoginFragment()

    }
}