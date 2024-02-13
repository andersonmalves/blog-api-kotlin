package com.kotlin.blog.repository

import com.kotlin.blog.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long> {
    fun findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(title: String, content: String): List<Post>

    @Query("SELECT p FROM Post p JOIN p.categories c WHERE " +
            "(:keyword IS NULL OR p.title LIKE %:keyword% OR p.content LIKE %:keyword%) " +
            "AND (:category IS NULL OR c.name = :category) " +
            "AND (:tag IS NULL OR EXISTS (SELECT 1 FROM p.tags t WHERE t.name = :tag)) " +
            "AND (:status IS NULL OR p.status = :status)")
    fun advancedSearch(keyword: String?, category: String?, tag: String?, status: String?, pageable: Pageable): Page<Post>
}