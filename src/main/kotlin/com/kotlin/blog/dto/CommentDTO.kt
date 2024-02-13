package com.kotlin.blog.dto

data class CommentDTO(
    val postId: Long,
    val userId: Long,
    val parentId: Long?,
    val content: String
)