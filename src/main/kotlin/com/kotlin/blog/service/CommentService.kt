package com.kotlin.blog.service

import com.kotlin.blog.dto.request.CommentRequest
import com.kotlin.blog.model.Comment
import com.kotlin.blog.repository.CommentRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CommentService (
    private val commentRepository: CommentRepository,
    private val postService: PostService,
    private val userService: UserService
) {

    fun getCommentsByPostId(postId: Long): List<Comment> {
        return commentRepository.findByPostId(postId)
    }

    fun createComment(commentRequest: CommentRequest): Comment {
        val publicationDate = LocalDateTime.now()
        val post = postService.getPostById(commentRequest.postId)
        val user = userService.getUserById(commentRequest.userId)

        val comment = Comment(content = commentRequest.content,
            post = post,
            user = user,
            publicationDate = publicationDate
        )

        return commentRepository.save(comment)
    }
}