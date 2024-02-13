package com.kotlin.blog.controller

import com.kotlin.blog.dto.enums.Status
import com.kotlin.blog.dto.mapper.PostMapper.toResponse
import com.kotlin.blog.dto.response.PostResponse
import com.kotlin.blog.model.Post
import com.kotlin.blog.service.PostService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping
    fun getAllPosts(pageable: Pageable): ResponseEntity<Page<PostResponse>> {
        val posts = postService.getAllPosts(pageable).toResponse()
        return ResponseEntity(posts, HttpStatus.OK)
    }

    @GetMapping("/search")
    fun searchPostsByKeyword(@RequestParam keyword: String): ResponseEntity<List<PostResponse>> {
        val posts = postService.searchPostsByKeyword(keyword).toResponse()
        return ResponseEntity(posts, HttpStatus.OK)
    }

    @PatchMapping("/{postId}/status")
    fun updatePostStatus(
        @PathVariable postId: Long,
        @RequestParam status: Status
    ): ResponseEntity<PostResponse> {
        val updatedPost = postService.updatePostStatus(postId, status)
        return ResponseEntity.ok(updatedPost.toResponse())
    }


}