package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.data.RepositoryImpl
import com.expv1n.onlineshop.domain.usecases.AddUserUseCase
import com.expv1n.onlineshop.domain.usecases.GetUserUseCase
import com.expv1n.onlineshop.presentation.LoginFragment

class SingInPageFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    val addUser = AddUserUseCase(repository)
    val checkUser = GetUserUseCase(repository)



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