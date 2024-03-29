package com.kotlin.blog.dto.mapper

import com.kotlin.blog.dto.mapper.CategoryMapper.toResponse
import com.kotlin.blog.dto.mapper.CommentMapper.toResponse
import com.kotlin.blog.dto.response.PostResponse
import com.kotlin.blog.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

object PostMapper {
    fun Post.toResponse(): PostResponse {
        return PostResponse(
            id = id!!,
            title = title,
            content = content,
            user = user.name,
            categories = categories.map { it.name },
            comments = comments.map { it.toResponse() },
            status = status.name,
            createdAt = createdAt
        )
    }

    fun List<Post>.toResponse(): List<PostResponse> {
        return map { it.toResponse() }
    }

    fun Page<Post>.toResponse(): Page<PostResponse> {
        val postsResponse = this.content.map { it.toResponse() }
        return PageImpl(postsResponse, this.pageable, this.totalElements)
    }
}