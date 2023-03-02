package com.expv1n.onlineshop.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.User
import com.example.domain.usecases.AddUserUseCase
import com.example.domain.usecases.GetPresenceOfUserByEmailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingInPageFragmentViewModel @Inject constructor(
    private val addUser: AddUserUseCase,
    private val checkUser: GetPresenceOfUserByEmailUseCase
) : ViewModel() {


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