package com.kotlin.blog.service

import com.kotlin.blog.dto.request.TagRequest
import com.kotlin.blog.model.Tag
import com.kotlin.blog.repository.TagRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {
    fun getAllTags(): List<Tag> {
        return tagRepository.findAll()
    }

    fun createTag(tagRequest: TagRequest): Tag {
        require(tagRequest.name.isNotBlank()) { "O nome da tag não pode estar em branco." }

        val tag = Tag(name = tagRequest.name)
        return tagRepository.save(tag)
    }

    fun findByIds(ids: List<Long>): Set<Tag> {
        return try {
            tagRepository.findAllById(ids).toSet()
        } catch (e: NoSuchElementException) {
            log.error("Elemento não encontrado ao buscar tags por IDs: ${e.message}")
            emptySet()
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}