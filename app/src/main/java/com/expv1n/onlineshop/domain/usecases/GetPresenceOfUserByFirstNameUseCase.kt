package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.repository.Repository

class GetPresenceOfUserByFirstNameUseCase(val repository: Repository) {

    suspend fun getUserByFirstName(fistName: String): Boolean {
        return repository.getPresenceOfUserByFirstName(fistName)
    }

}