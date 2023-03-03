package com.expv1n.data.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE first_name = :firstName")
    suspend fun getUser(firstName: String): UserEntity

    @Query("DELETE FROM users WHERE id=:userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT EXISTS (SELECT 1 FROM users WHERE email = :userEmail)")
    fun existsEmail(userEmail: String): Boolean

    @Query("SELECT EXISTS (SELECT 1 FROM users WHERE first_name = :firstName)")
    fun existsName(firstName: String): Boolean

}