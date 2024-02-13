package com.kotlin.blog.service

import com.kotlin.blog.dto.mapper.UserMapper.toEntity
import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.exceptions.ResourceNotFoundException
import com.kotlin.blog.model.User
import com.kotlin.blog.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.collections.List

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun createUser(request: UserRequest): User {
        require(request.email.isNotBlank()) { "O e-mail não pode estar em branco" }
        require(userRepository.findByEmail(request.email) == null) { "E-mail já está em uso" }

        val user = request.toEntity()
        return userRepository.save(user)
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
            ?: throw ResourceNotFoundException("Email não encontrado")
    }

    fun findAllUsers(): List<User> {
        val userList = userRepository.findAll()
        log.info("Total de usuários: {}", userList.size)
        return userList
    }

    fun getUserById(id: Long): User {
        return userRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Usuário não encontrado com ID: $id") }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}