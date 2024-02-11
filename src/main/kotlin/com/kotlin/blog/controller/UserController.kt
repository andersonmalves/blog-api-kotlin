package com.kotlin.blog.controller

import com.kotlin.blog.dto.request.UserRequest
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
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<User> {
        val createdUser = userService.createUser(request)
        return ResponseEntity(createdUser, HttpStatus.CREATED)
    }

    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User> {
        val user = userService.getUserByEmail(email)
        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}