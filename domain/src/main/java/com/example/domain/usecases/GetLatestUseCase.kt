package com.example.domain.usecases

import com.example.domain.models.Latest
import com.example.domain.repository.Repository

class GetLatestUseCase(val repository: Repository) {
    suspend fun getLatest(): List<Latest> = repository.getLatest()
}
