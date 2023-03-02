package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.RepositoryImpl
import com.example.domain.models.User
import com.example.domain.usecases.AddUserUseCase
import com.example.domain.usecases.GetPresenceOfUserByEmailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingInPageFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private val addUser = AddUserUseCase(repository)
    private val checkUser = GetPresenceOfUserByEmailUseCase(repository)
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