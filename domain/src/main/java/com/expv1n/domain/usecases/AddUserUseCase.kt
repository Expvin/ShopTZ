package com.expv1n.domain.usecases

import com.expv1n.domain.models.User
import com.expv1n.domain.repository.Repository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(val repository: Repository) {

    suspend fun addUser(user: User) = repository.addUser(user)

}