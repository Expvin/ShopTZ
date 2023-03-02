package com.example.domain.usecases

import com.example.domain.models.Latest
import com.example.domain.repository.Repository
import javax.inject.Inject

class GetLatestUseCase @Inject constructor(val repository: Repository) {
    suspend fun getLatest(): List<Latest> = repository.getLatest()
}
