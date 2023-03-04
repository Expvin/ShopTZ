package com.expv1n.onlineshop.presentation

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.expv1n.domain.models.User
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.databinding.FragmentSignInPageBinding
import com.expv1n.onlineshop.ShopApplication
import com.expv1n.onlineshop.presentation.utils.SafeClickListener
import com.expv1n.onlineshop.presentation.viewmodel.SingInPageFragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class SignInPageFragment : Fragment() {

    private var _binding: FragmentSignInPageBinding? = null
    private val binding: FragmentSignInPageBinding
        get() = _binding ?: throw RuntimeException("Unknown binding")


    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private lateinit var viewModel: SingInPageFragmentViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val component by lazy {
        (requireActivity().application as ShopApplication).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInPageBinding.inflate(inflater, container, false)
        singInUser()
        loginSetOnClickListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[SingInPageFragmentViewModel::class.java]
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? MainActivity)?.hideBottomNavigationView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun checkInputField() {
        if (binding.singInFirstNameEditText.text.toString().isEmpty()) {
            binding.singInFirstNameEditText.error =  getString(R.string.the_field_cannot_be_empty)
        }
        if (binding.singInLastNameEditText.text.toString().isEmpty()) {
            binding.singInLastNameEditText.error =  getString(R.string.the_field_cannot_be_empty)
        }
        if (binding.singInEmailEditText.text.toString().isEmpty()) {
            binding.singInEmailEditText.error =  getString(R.string.the_field_cannot_be_empty)
        }
    }

    private fun singInUser() {
        binding.singInButton.setSafeOnClickListener {
            checkInputField()
            if (binding.singInEmailEditText.text.toString().isEmailValid()) {
                coroutineScope.launch {
                    viewModel.availabilityCheckUser(binding.singInEmailEditText.text.toString())
                }
                viewModel.checkUserLiveData.observe(requireActivity()) {
                    if (it == true) {
                        binding.singInFirstNameEditText.error =  getString(R.string.such_user_already_exists)
                    } else if (it == false) {
                        coroutineScope.launch {
                            viewModel.createUser(
                                User(
                                    0,
                                    first_name = binding.singInFirstNameEditText.text.toString(),
                                    last_name = binding.singInLastNameEditText.text.toString(),
                                    email = binding.singInEmailEditText.text.toString(),
                                    password = "1234"
                                )
                            )
                        }
                        launchFragment(Page1Fragment.getInstance(), Page1Fragment.NAME)
                    }
                }
            } else {
                binding.singInEmailEditText.error =  getString(R.string.enter_a_valid_email)
            }
        }
    }



    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }

    fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
        val safeClickListener = SafeClickListener {
            onSafeClick(it)
        }
        setOnClickListener(safeClickListener)
    }

    private fun loginSetOnClickListener() {
        binding.singInLoginTextView.setSafeOnClickListener {
            launchFragment(LoginFragment.getInstance(), LoginFragment.NAME)

        }

    }

    private fun launchFragment(fragment: Fragment, fragmentName: String) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragmentName)
            .commit()
    }

    companion object {

        const val NAME = "SignInPageFragment"

        fun getInstance() = SignInPageFragment()

    }

}