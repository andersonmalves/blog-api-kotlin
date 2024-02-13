package com.kotlin.blog.service

import com.kotlin.blog.dto.request.TagRequest
import com.kotlin.blog.model.Tag
import com.kotlin.blog.repository.TagRepository
import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {
    fun getAllTags(): List<Tag> {
        return tagRepository.findAll()
    }

    fun createTag(tagRequest: TagRequest): Tag {
        val tag = Tag(name = tagRequest.name)
        return tagRepository.save(tag)
    }
}