package com.kotlin.blog.repository

import com.kotlin.blog.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {
    // fun findAllById(ids: List<Long>): List<Category>
}