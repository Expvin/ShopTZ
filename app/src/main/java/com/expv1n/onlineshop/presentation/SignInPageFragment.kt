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
        loginSetOnClickListener()
        singInUser()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }

    private fun singInUser() {
        binding.singInButton.setOnClickListener {
            if (binding.singInEmailEditText.text.toString().isEmailValid()) {
                Toast.makeText(requireActivity(), "OKey", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Not valied email", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun loginSetOnClickListener() {
        binding.singInLoginTextView.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainerView, LoginFragment.getInstance())
                .addToBackStack(LoginFragment.NAME)
                .commit()
        }
    }

}