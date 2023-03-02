package com.example.domain.usecases

import com.example.domain.models.User
import com.example.domain.repository.Repository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(val repository: Repository) {

    suspend fun addUser(user: User) = repository.addUser(user)

}