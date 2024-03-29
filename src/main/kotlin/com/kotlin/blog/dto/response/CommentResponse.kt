package com.kotlin.blog.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CommentResponse(
    val content: String,
    val user: String,
    val publicationDate: LocalDateTime
)
