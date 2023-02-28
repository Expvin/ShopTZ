package com.expv1n.onlineshop.data

import android.app.Application
import com.expv1n.onlineshop.data.database.AppDatabase
import com.expv1n.onlineshop.data.mapper.Mapper
import com.expv1n.onlineshop.data.newtwork.ApiFactory
import com.expv1n.onlineshop.domain.models.FlashSale
import com.expv1n.onlineshop.domain.models.Latest
import com.expv1n.onlineshop.domain.models.User
import com.expv1n.onlineshop.domain.repository.Repository

class RepositoryImpl(application: Application): Repository {

    private val databaseDao = AppDatabase.getInstance(application).getUserDao()
    private val apiFactory = ApiFactory()
    private val apiService = apiFactory.apiService
    private val mapper = Mapper()

    override suspend fun getLatest(): List<Latest> {
        return apiService.getLatest().latest
    }

    override suspend fun getFlashSale(): List<FlashSale> {
        return apiService.getFlashSale()
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