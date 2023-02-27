package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.repository.Repository

class GetPresenceOfUserByEmailUseCase(val repository: Repository) {
    suspend fun getUser(email: String): Boolean {
        return repository.getPresenceOfUserByEmail(email)
    }
}