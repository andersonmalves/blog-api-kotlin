package com.kotlin.blog.service

import com.kotlin.blog.model.Category
import com.kotlin.blog.repository.CategoryRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }

    fun findByIds(ids: List<Long>): List<Category> {
        try {
            return categoryRepository.findAllById(ids).toList()
        } catch (e: NoSuchElementException) {
            log.error("Elemento não encontrado ao buscar categorias por IDs: ${e.message}")
            return emptyList()
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}