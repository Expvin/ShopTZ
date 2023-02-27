package com.expv1n.onlineshop.domain.repository

import com.expv1n.onlineshop.domain.models.FlashSale
import com.expv1n.onlineshop.domain.models.Latest
import com.expv1n.onlineshop.domain.models.User

interface Repository {

    suspend fun getLatest(): List<Latest>

    suspend fun getFlashSale(): List<FlashSale>

    suspend fun addUser(user: User)

    suspend fun getUser(userEmail: String): Boolean



}