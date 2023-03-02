package com.example.domain.usecases

import com.example.domain.models.FlashSale
import com.example.domain.repository.Repository

class GetFlashSaleUseCase(val repository: Repository) {
    suspend fun getFlashSale(): List<FlashSale> = repository.getFlashSale()
}