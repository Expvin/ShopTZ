package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.repository.Repository

class GetUserUseCase(val repository: Repository) {
    suspend fun getUser(email: String): Boolean {
        return repository.getUser(email)
    }
}