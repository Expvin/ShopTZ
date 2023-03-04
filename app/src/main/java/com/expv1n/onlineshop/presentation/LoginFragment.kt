package com.expv1n.onlineshop.presentation

import android.content.Context
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
import com.expv1n.onlineshop.ShopApplication
import com.expv1n.onlineshop.databinding.FragmentLoginBinding
import com.expv1n.onlineshop.presentation.viewmodel.LoginFragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var viewModel: LoginFragmentViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as ShopApplication).component
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? MainActivity)?.hideBottomNavigationView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginFragmentViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initButton() {
        binding.logInButton.setOnClickListener {
            checkUserAvailability()
            checkInputField()
        }
    }

    private fun checkInputField() {
        if (binding.welcomeFirstNameEditText.text.toString().isEmpty()) {
            binding.welcomeFirstNameEditText.error =  getString(R.string.the_field_cannot_be_empty)
        }
        if (binding.welcomePasswordEditText.text.toString().isEmpty()) {
            binding.welcomePasswordEditText.error =  getString(R.string.the_field_cannot_be_empty)
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
                            binding.welcomePasswordEditText.error = getString(R.string.wrong_password)
                        }
                    }
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