package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.dto.response.UserResponse
import com.kotlin.blog.model.User

object UserMapper {
    fun UserRequest.toEntity(): User {
        return User(
            name = name,
            email = email,
            password = password
        )
    }

    fun User.toResponse(): UserResponse {
        return UserResponse(
            name = name,
            email = email
        )
    }

    fun List<User>.toResponse(): List<UserResponse> {
        return map { it.toResponse() }
    }
}