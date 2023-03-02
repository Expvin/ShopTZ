package com.example.domain.usecases

import com.example.domain.repository.Repository
import javax.inject.Inject

class GetPresenceOfUserByEmailUseCase @Inject constructor(val repository: Repository) {
    suspend fun getUser(email: String): Boolean {
        return repository.getPresenceOfUserByEmail(email)
    }
}