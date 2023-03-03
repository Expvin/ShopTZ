package com.expv1n.domain.repository

import com.expv1n.domain.models.FlashSale
import com.expv1n.domain.models.Latest
import com.expv1n.domain.models.User

interface Repository {

    suspend fun getLatest(): List<Latest>

    suspend fun getFlashSale(): List<FlashSale>

    suspend fun addUser(user: User)

    suspend fun getPresenceOfUserByEmail(userEmail: String): Boolean

    suspend fun getPresenceOfUserByFirstName(firstName: String): Boolean

    suspend fun getUser(fistName: String): User

}