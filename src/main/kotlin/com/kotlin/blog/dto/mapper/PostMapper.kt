package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.response.PostResponse
import com.kotlin.blog.model.Post

object PostMapper {
    fun Post.toResponse(): PostResponse {
        return PostResponse(
            id = id!!,
            title = title,
            content = content,
            createdAt = createdAt
        )
    }

    fun List<Post>.toResponse(): List<PostResponse> {
        return map { it.toResponse() }
    }
}