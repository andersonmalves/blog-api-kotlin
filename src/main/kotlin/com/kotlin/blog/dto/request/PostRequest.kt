package com.kotlin.blog.dto.request

data class PostRequest(
    val title: String,
    val content: String,
    val userId: Long,
    val categoryIds: List<Long>,
    val tagIds: List<Long>,
    val status: String
)
