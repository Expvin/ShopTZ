package com.example.data.mapper

import com.example.data.database.UserEntity
import com.example.domain.models.User
import javax.inject.Inject

class Mapper @Inject constructor(){

    fun modelToEntity(user: User) = UserEntity (
        id = 0,
        first_name = user.first_name,
        last_name = user.last_name,
        email = user.email,
        password = "1234")

    fun entityToModel(user: UserEntity) = User (
        id = user.id,
        first_name = user.first_name,
        last_name = user.last_name,
        email = user.email,
        password = user.password)

}