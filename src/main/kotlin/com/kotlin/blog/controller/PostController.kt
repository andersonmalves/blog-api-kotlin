package com.kotlin.blog.controller

import com.kotlin.blog.dto.enums.Status
import com.kotlin.blog.dto.mapper.PostMapper.toResponse
import com.kotlin.blog.dto.request.PostRequest
import com.kotlin.blog.dto.response.PostResponse
import com.kotlin.blog.service.PostService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    /*
        curl -X GET 'http://localhost:8080/posts?page=0&size=10&keyword=exemplo&category=tecnologia&tag=java&status=published'
     */
    @GetMapping("/advanced")
    fun advancedSearch(
        @RequestParam(required = false) keyword: String?,
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) tag: String?,
        @RequestParam(required = false) status: String?,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): ResponseEntity<Page<PostResponse>> {
        val posts = postService.advancedSearch(keyword, category, tag, status, page, size)
            .map { it.toResponse() }
        return ResponseEntity(posts, HttpStatus.OK)
    }
    @PostMapping("/posts")
    fun createPost(@RequestBody request: PostRequest): ResponseEntity<PostResponse> {
        val createdPost = postService.createPost(request)
        val response = createdPost.toResponse()
        return ResponseEntity(response, HttpStatus.CREATED)
    }


}