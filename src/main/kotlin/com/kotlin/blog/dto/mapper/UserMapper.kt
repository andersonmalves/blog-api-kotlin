package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.model.User

object UserMapper {
    fun UserRequest.toEntity(): User {
        return User(
            name = name,
            email = email,
            password = password
        )
    }
}