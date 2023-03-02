package com.example.domain.models


data class User (
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String )