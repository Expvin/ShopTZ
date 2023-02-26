package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.models.User
import com.expv1n.onlineshop.domain.repository.Repository

class AddUserUseCase(val repository: Repository) {

    suspend fun addUser(user: User) = repository.addUser(user)

}