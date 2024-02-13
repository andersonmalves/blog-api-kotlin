package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.response.TagResponse
import com.kotlin.blog.model.Tag

object TagMapper {
    fun Tag.toResponse(): TagResponse {
        return TagResponse(
            id = id!!,
            name = name
        )
    }

    fun List<Tag>.toResponse(): List<TagResponse> {
        return map { it.toResponse() }
    }
}