package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.CommentDTO
import com.kotlin.blog.dto.request.CommentRequest
import com.kotlin.blog.dto.response.CommentResponse
import com.kotlin.blog.model.Comment

object CommentMapper {
    fun Comment.toResponse(): CommentResponse {
        return CommentResponse(
            content = content,
            user = user.name,
            publicationDate = publicationDate
        )
    }

    fun List<Comment>.toResponse(): List<CommentResponse> {
        return map { it.toResponse() }
    }

    fun CommentRequest.toDTO(): CommentDTO {
        return CommentDTO(
            postId = postId,
            userId = userId,
            parentId = parentId,
            content = content
        )
    }
}