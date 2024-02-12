package com.kotlin.blog.service

import com.kotlin.blog.model.Post
import com.kotlin.blog.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }
}