package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.models.Latest
import com.expv1n.onlineshop.domain.repository.Repository

class GetLatestUseCase(val repository: Repository) {
    suspend fun getLatest(): List<Latest> = repository.getLatest()
}
