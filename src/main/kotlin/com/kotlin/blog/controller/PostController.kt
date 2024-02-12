package com.kotlin.blog.controller

import com.kotlin.blog.dto.mapper.PostMapper.toResponse
import com.kotlin.blog.dto.response.PostResponse
import com.kotlin.blog.model.Post
import com.kotlin.blog.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping
    fun getAllPosts(): ResponseEntity<List<PostResponse>> {
        val postsList = postService.getAllPosts().toResponse()
        return ResponseEntity(postsList, HttpStatus.OK)
    }
}