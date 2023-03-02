package com.expv1n.onlineshop.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.User
import com.example.domain.usecases.GetPresenceOfUserByFirstNameUseCase
import com.example.domain.usecases.GetUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    private val getUser: GetUserUseCase,
    private val getPresenceOfUserByFirstNameUseCase:
    GetPresenceOfUserByFirstNameUseCase
) : ViewModel() {


    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val _userLiveData = MutableLiveData<Boolean>()
    val userLiveData: LiveData<Boolean>
        get() = _userLiveData

    private val _checkUserLiveData = MutableLiveData<Boolean>()
    val checkUserLiveData: LiveData<Boolean>
        get() = _checkUserLiveData

    fun checkUser(firstName: String, password: String) {
        coroutineScope.launch {
            val user: User = getUser.getUser(firstName)
            if (user.first_name == (firstName) && user.password == (password)) {
                _userLiveData.postValue(true)
            } else {
                _userLiveData.postValue(false)
            }
        }

    }

    fun checkAvailability(firstName: String) {
        coroutineScope.launch {
            _checkUserLiveData.postValue(
                getPresenceOfUserByFirstNameUseCase
                    .getUserByFirstName(firstName)
            )
        }
    }

}