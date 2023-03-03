package com.expv1n.domain.usecases

import com.expv1n.domain.models.FlashSale
import com.expv1n.domain.repository.Repository
import javax.inject.Inject

class GetFlashSaleUseCase @Inject constructor(val repository: Repository) {
    suspend fun getFlashSale(): List<FlashSale> = repository.getFlashSale()
}