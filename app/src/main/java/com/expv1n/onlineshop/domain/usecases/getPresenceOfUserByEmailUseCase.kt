package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.repository.Repository

class getPresenceOfUserByEmailUseCase(val repository: Repository) {
    suspend fun getUser(email: String): Boolean {
        return repository.getPresenceOfUserByEmail(email)
    }
}