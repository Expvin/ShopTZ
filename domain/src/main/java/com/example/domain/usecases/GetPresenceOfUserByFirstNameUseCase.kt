package com.example.domain.usecases

import com.example.domain.repository.Repository

class GetPresenceOfUserByFirstNameUseCase(val repository: Repository) {

    suspend fun getUserByFirstName(fistName: String): Boolean {
        return repository.getPresenceOfUserByFirstName(fistName)
    }

}