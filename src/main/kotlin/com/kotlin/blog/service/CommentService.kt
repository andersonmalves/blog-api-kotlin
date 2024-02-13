package com.kotlin.blog.service

import com.kotlin.blog.dto.mapper.CommentMapper.toDTO
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
        val commentDTO = commentRequest.toDTO()
        val post = postService.getPostById(commentDTO.postId)
        val user = userService.getUserById(commentDTO.userId)

        if (commentDTO.parentId != null) {
            val parentComment = commentRepository.findById(commentDTO.parentId)
                .orElseThrow { throw NoSuchElementException("Comentário pai não encontrado") }
            require(parentComment.post.id == commentDTO.postId) { "O comentário pai não pertence ao mesmo post" }
        }

        val comment = Comment(content = commentDTO.content,
            post = post,
            user = user,
            publicationDate = LocalDateTime.now()
        )

        return commentRepository.save(comment)
    }
}