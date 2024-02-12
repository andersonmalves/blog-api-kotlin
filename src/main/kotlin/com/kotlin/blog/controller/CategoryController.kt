package com.kotlin.blog.controller

import com.kotlin.blog.dto.mapper.CategoryMapper.toResponse
import com.kotlin.blog.dto.response.CategoryResponse
import com.kotlin.blog.model.Category
import com.kotlin.blog.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryResponse>> {
        val categories = categoryService.getAllCategories().toResponse()
        return ResponseEntity(categories, HttpStatus.OK)
    }
}