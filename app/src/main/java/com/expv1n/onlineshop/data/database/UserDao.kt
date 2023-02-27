package com.expv1n.onlineshop.data.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserEntity)
//
//    @Query("SELECT * FROM users WHERE email=:userEmail")
//    suspend fun checkUserByEmail(userEmail: String): Boolean

    @Query("DELETE FROM users WHERE id=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT EXISTS (SELECT 1 FROM users WHERE email = :userEmail)")
    fun exists(userEmail: String): Boolean

}