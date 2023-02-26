package com.expv1n.onlineshop.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String)