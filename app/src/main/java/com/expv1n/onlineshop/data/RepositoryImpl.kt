package com.expv1n.onlineshop.data

import android.app.Application
import android.util.Log
import com.expv1n.onlineshop.data.database.AppDatabase
import com.expv1n.onlineshop.data.database.UserEntity
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
        return apiService.getLatest()
    }

    override suspend fun getFlashSale(): List<FlashSale> {
        return apiService.getFlashSale()    }

    override suspend fun addUser(user: User) {
        databaseDao.addUser(mapper.modelToEntity(user))
    }

    override suspend fun getUser(userEmail: String): Boolean {
        if (databaseDao.exists(userEmail)) {
               Log.d("Repository", "return true")
               return true
        }
        Log.d("Repository", "return false")
        return false
    }
}