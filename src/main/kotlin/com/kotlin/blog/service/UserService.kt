package com.kotlin.blog.service

import com.kotlin.blog.dto.mapper.UserMapper.toEntity
import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.model.User
import com.kotlin.blog.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import kotlin.collections.List

@Service
class UserService(
    @Autowired
    private val userRepository: UserRepository
) {
    fun createUser(request: UserRequest): User {
        require(userRepository.findByEmail(request.email) == null) { "E-mail já está em uso" }
        return userRepository.save(request.toEntity())
    }

    fun getUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
            ?: throw NotFoundException()
    }

    fun findAllUsers(): List<User> {
        val userList = userRepository.findAll()
        log.info("Total de users: {}", userList.size)
        return userList
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}