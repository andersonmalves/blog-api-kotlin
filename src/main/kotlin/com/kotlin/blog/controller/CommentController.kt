package com.kotlin.blog.controller

import com.kotlin.blog.dto.mapper.CommentMapper.toResponse
import com.kotlin.blog.dto.response.CommentResponse
import com.kotlin.blog.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comments")
class CommentController (
    private val commentService: CommentService
) {
    @GetMapping
    fun getCommentsByPostId(@PathVariable postId: Long): ResponseEntity<List<CommentResponse>> {
        val comments = commentService.getCommentsByPostId(postId).toResponse()
        return ResponseEntity(comments, HttpStatus.OK)
    }

}