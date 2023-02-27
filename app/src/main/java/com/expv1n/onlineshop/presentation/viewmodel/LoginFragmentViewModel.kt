package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.expv1n.onlineshop.domain.models.User

class LoginFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User>
        get() = _userLiveData

    private fun checkUser(firstName: String, password:String) {

    }


}