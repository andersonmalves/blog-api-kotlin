package com.kotlin.blog.repository

import com.kotlin.blog.model.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {
}