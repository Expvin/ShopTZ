package com.expv1n.domain.usecases

import com.expv1n.domain.models.Latest
import com.expv1n.domain.repository.Repository
import javax.inject.Inject

class GetLatestUseCase @Inject constructor(val repository: Repository) {
    suspend fun getLatest(): List<Latest> = repository.getLatest()
}
