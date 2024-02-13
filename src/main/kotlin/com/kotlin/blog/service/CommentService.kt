package com.kotlin.blog.service

import com.kotlin.blog.model.Comment
import com.kotlin.blog.repository.CommentRepository
import org.springframework.stereotype.Service

@Service
class CommentService (
    private val commentRepository: CommentRepository
) {

    fun getCommentsByPostId(postId: Long): List<Comment> {
        return commentRepository.findByPostId(postId)
    }
}