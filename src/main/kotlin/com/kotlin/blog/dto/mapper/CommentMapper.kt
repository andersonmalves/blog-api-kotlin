package com.kotlin.blog.dto.mapper

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
}