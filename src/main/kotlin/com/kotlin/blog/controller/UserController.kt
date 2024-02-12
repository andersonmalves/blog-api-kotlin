package com.kotlin.blog.controller

import com.kotlin.blog.dto.mapper.UserMapper.toResponse
import com.kotlin.blog.dto.request.UserRequest
import com.kotlin.blog.dto.response.UserResponse
import com.kotlin.blog.model.User
import com.kotlin.blog.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<UserResponse> {
        val createdUser = userService.createUser(request).toResponse()
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<UserResponse> {
        val user = userService.getUserByEmail(email)
        return ResponseEntity(user?.toResponse(), HttpStatus.OK)
    }

    @GetMapping
    fun findAllUsers(): ResponseEntity<List<UserResponse>> {
        val users = userService.findAllUsers().toResponse()
        return ResponseEntity(users, HttpStatus.OK)
    }
}