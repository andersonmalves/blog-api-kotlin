package com.kotlin.blog.model

import jakarta.persistence.*

@Entity
@Table(name = "`user`")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String
)
