package com.expv1n.domain.usecases

import com.expv1n.domain.repository.Repository
import javax.inject.Inject

class GetPresenceOfUserByFirstNameUseCase @Inject constructor(val repository: Repository) {

    suspend fun getUserByFirstName(fistName: String): Boolean {
        return repository.getPresenceOfUserByFirstName(fistName)
    }

}