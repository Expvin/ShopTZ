package com.example.domain.usecases

import com.example.domain.models.User
import com.example.domain.repository.Repository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(val repository: Repository) {

    suspend fun getUser(firstName: String): User {
        return repository.getUser(firstName)
    }

}