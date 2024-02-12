package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.response.CategoryResponse
import com.kotlin.blog.model.Category

object CategoryMapper {
    fun Category.toResponse(): CategoryResponse {
        return CategoryResponse(
            name = name
        )
    }

    fun List<Category>.toResponse(): List<CategoryResponse> {
        return map { it.toResponse() }
    }
}