package com.kotlin.blog.repository

import com.kotlin.blog.model.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(title: String, content: String): List<Post>
}