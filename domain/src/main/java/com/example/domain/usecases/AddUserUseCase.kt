package com.example.domain.usecases

import com.example.domain.models.User
import com.example.domain.repository.Repository

class AddUserUseCase(val repository: Repository) {

    suspend fun addUser(user: User) = repository.addUser(user)

}