package com.example.domain.usecases

import com.example.domain.repository.Repository
import javax.inject.Inject

class GetPresenceOfUserByFirstNameUseCase @Inject constructor(val repository: Repository) {

    suspend fun getUserByFirstName(fistName: String): Boolean {
        return repository.getPresenceOfUserByFirstName(fistName)
    }

}