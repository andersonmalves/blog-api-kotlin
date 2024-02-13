package com.kotlin.blog.dto.request

data class CommentRequest(
    val postId: Long,
    val userId: Long,
    val parentId: Long?,
    val content: String
)
