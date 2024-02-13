package com.kotlin.blog.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val user: String,
    val categories: List<String>,
    val comments: List<CommentResponse>,
    val status: String,
    val createdAt: LocalDateTime
)
