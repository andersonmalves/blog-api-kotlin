package com.kotlin.blog.controller

import com.kotlin.blog.dto.request.TagRequest
import com.kotlin.blog.dto.response.TagResponse
import com.kotlin.blog.model.Tag
import com.kotlin.blog.service.TagService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tags")
class TagController(
    private val tagService: TagService
) {

    @GetMapping
    fun getAllTags(): ResponseEntity<List<TagResponse>> {
        val tags = tagService.getAllTags()
        return ResponseEntity(tags, HttpStatus.OK)
    }

    @PostMapping
    fun createTag(@RequestBody tagRequest: TagRequest): ResponseEntity<TagResponse> {
        val createdTag = tagService.createTag(tagRequest)
        return ResponseEntity(createdTag, HttpStatus.CREATED)
    }
}