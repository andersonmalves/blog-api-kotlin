package com.kotlin.blog.service

import com.kotlin.blog.model.Post
import com.kotlin.blog.repository.PostRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    fun getAllPosts(): List<Post> {
        val posts = postRepository.findAll()
        posts.map { log.info(it.toString()) }
        return posts
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}

