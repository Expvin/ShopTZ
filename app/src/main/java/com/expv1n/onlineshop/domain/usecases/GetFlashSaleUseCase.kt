package com.expv1n.onlineshop.domain.usecases

import com.expv1n.onlineshop.domain.models.FlashSale
import com.expv1n.onlineshop.domain.repository.Repository

class GetFlashSaleUseCase(val repository: Repository) {
    suspend fun getFlashSale(): List<FlashSale> = repository.getFlashSale()
}