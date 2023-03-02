package com.example.domain.usecases

import com.example.domain.repository.Repository

class GetPresenceOfUserByEmailUseCase(val repository: Repository) {
    suspend fun getUser(email: String): Boolean {
        return repository.getPresenceOfUserByEmail(email)
    }
}