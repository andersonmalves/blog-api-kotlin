package com.kotlin.blog.service

import com.kotlin.blog.dto.mapper.UserMapper.toEntity
import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.model.User
import com.kotlin.blog.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(request: UserRequest): User {
        if (userRepository.findByEmail(request.email) != null) {
            throw IllegalArgumentException("E-mail já está em uso")
        }

        return userRepository.save(request.toEntity())
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}