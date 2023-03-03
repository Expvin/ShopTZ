package com.expv1n.domain.usecases

import com.expv1n.domain.models.User
import com.expv1n.domain.repository.Repository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(val repository: Repository) {

    suspend fun getUser(firstName: String): User {
        return repository.getUser(firstName)
    }

}