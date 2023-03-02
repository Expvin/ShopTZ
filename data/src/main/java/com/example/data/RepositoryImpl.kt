package com.example.data

import android.app.Application
import com.example.data.database.AppDatabase
import com.example.data.database.UserDao
import com.example.data.mapper.Mapper
import com.example.data.newtwork.ApiFactory
import com.example.data.newtwork.ApiService
import com.example.domain.models.FlashSale
import com.example.domain.models.Latest
import com.example.domain.models.User
import com.example.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    application: Application,
    private val databaseDao: UserDao,
    private val apiService: ApiService,
    private val mapper: Mapper
    ): Repository {


    override suspend fun getLatest(): List<Latest> {
        return apiService.getLatest().latest
    }

    override suspend fun getFlashSale(): List<FlashSale> {
        return apiService.getFlashSale().flash_sale
    }

    override suspend fun addUser(user: User) {
        databaseDao.addUser(mapper.modelToEntity(user))
    }

    override suspend fun getPresenceOfUserByEmail(userEmail: String): Boolean {
        if (databaseDao.existsEmail(userEmail)) {
               return true
        }
        return false
    }

    override suspend fun getPresenceOfUserByFirstName(firstName: String): Boolean {
        if (databaseDao.existsName(firstName)) {
            return true
        }
        return false
    }

    override suspend fun getUser(fistName: String): User {
        return mapper.entityToModel(databaseDao.getUser(fistName))
    }
}