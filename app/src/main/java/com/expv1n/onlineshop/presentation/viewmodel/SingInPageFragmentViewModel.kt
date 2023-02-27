package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.expv1n.onlineshop.R
import com.expv1n.onlineshop.data.RepositoryImpl
import com.expv1n.onlineshop.domain.models.User
import com.expv1n.onlineshop.domain.usecases.AddUserUseCase
import com.expv1n.onlineshop.domain.usecases.GetUserUseCase
import com.expv1n.onlineshop.presentation.LoginFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SingInPageFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private val addUser = AddUserUseCase(repository)
    private val checkUser = GetUserUseCase(repository)
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val _checkUserLiveData = MutableLiveData<Boolean>()
    val checkUserLiveData: LiveData<Boolean>
        get() = _checkUserLiveData

    suspend fun availabilityCheckUser(email: String) {
        coroutineScope.launch {
            _checkUserLiveData.postValue(checkUser.getUser(email))
        }
    }

    suspend fun createUser(user: User) {
        addUser.addUser(user)
    }



}