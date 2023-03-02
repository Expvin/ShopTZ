package com.expv1n.onlineshop.di

import android.app.Application
import com.example.data.RepositoryImpl
import com.example.data.database.AppDatabase
import com.example.data.database.UserDao
import com.example.data.newtwork.ApiFactory
import com.example.data.newtwork.ApiService
import com.example.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        fun provideUserDao(application: Application): UserDao {
            return AppDatabase.getInstance(application).getUserDao()
        }

        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }

}