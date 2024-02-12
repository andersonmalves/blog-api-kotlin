package com.kotlin.blog.service

import com.kotlin.blog.model.Category
import com.kotlin.blog.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }
}