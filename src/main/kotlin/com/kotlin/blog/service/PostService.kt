package com.kotlin.blog.service

import com.kotlin.blog.dto.enums.Status
import com.kotlin.blog.dto.request.PostRequest
import com.kotlin.blog.model.Post
import com.kotlin.blog.repository.PostRepository
import jakarta.persistence.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    private val postRepository: PostRepository,
    private val userService: UserService,
    private val categoryService: CategoryService,
    private val tagService: TagService
) {
    fun getAllPosts(pageable: Pageable): Page<Post> {
        // posts.map { log.info(it.toString()) }
        return postRepository.findAll(pageable)
    }

    fun searchPostsByKeyword(keyword: String): List<Post> {
        return postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword)
    }

    @Transactional
    fun updatePostStatus(postId: Long, status: Status): Post {
        val post = getPostById(postId)
        return postRepository.save(post.copy(status = status))
    }

    fun getPostById(postId: Long): Post {
        return postRepository.findById(postId)
            .orElseThrow { EntityNotFoundException("Post not found with id: $postId") }
    }

    fun advancedSearch(keyword: String?, category: String?, tag: String?, status: String?, page: Int, size: Int): Page<Post> {
        val pageable = PageRequest.of(page, size)
        return postRepository.advancedSearch(keyword, category, tag, status, pageable)
    }

    fun createPost(request: PostRequest): Post {
        val user = userService.getUserById(request.userId)
        val categories = categoryService.findByIds(request.categoryIds)
        val tags = tagService.findByIds(request.tagIds)

        val post = Post(
            title = request.title,
            content = request.content,
            user = user,
            categories = categories.toList(),
            tags = tags,
            status = Status.fromString(request.status)
        )

        return postRepository.save(post)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}

