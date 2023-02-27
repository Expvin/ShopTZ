package com.expv1n.onlineshop.data.mapper

import com.expv1n.onlineshop.data.database.UserEntity
import com.expv1n.onlineshop.domain.models.User

class Mapper {

    fun modelToEntity(user: User) = UserEntity (
        id = 0,
        first_name = user.first_name,
        last_name = user.last_name,
        email = user.email,
        password = "1234")

//    fun entityToModel(user: UserEntity) = User (
//        id = user.id,
//        first_name = user.first_name,
//        last_name = user.last_name,
//        email = user.email,
//        password = user.email)

}