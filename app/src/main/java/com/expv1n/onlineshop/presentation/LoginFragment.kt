package com.expv1n.onlineshop.presentation

import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.FragmentLoginBinding
import com.expv1n.onlineshop.presentation.viewmodel.LoginFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val viewModel by lazy {
        ViewModelProvider(this)[LoginFragmentViewModel::class.java]
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? MainActivity)?.hideBottomNavigationView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        checkPasswordVisible()
        initButton()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initButton() {
        binding.logInButton.setOnClickListener {
            checkUserAvailability()
        }
    }

    private fun checkUserAvailability() {
        coroutineScope.launch {
            viewModel.checkAvailability(binding.welcomeFirstNameEditText.text.toString())
            viewModel.checkUserLiveData.observe(requireActivity()) {
                if (it == true) {
                    viewModel.checkUser(binding.welcomeFirstNameEditText.text.toString(),
                    binding.welcomePasswordEditText.text.toString())
                    viewModel.userLiveData.observe(requireActivity()) {
                        if (it == true) {
                            launchFragment(Page1Fragment.getInstance(), Page1Fragment.NAME)
                        } else {
                            Toast.makeText(requireActivity(), "Wrong password", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                }
            }
        }
    }

    private fun checkPasswordVisible() {
        var isVisible = true
        binding.checkPasswordImageView.setOnClickListener {
            if (isVisible) {
                binding.welcomePasswordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                isVisible = false
            } else {
                binding.welcomePasswordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                isVisible = true
            }
        }
    }

    private fun launchFragment(fragment: Fragment, fragmentName: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    companion object {

        const val NAME = "LoginFragment"

        fun getInstance() = LoginFragment()

    }
}