package com.kotlin.blog.dto.enums

enum class Status {
    DRAFT,
    PUBLISHED;

    companion object {
        fun fromString(value: String): Status {
            return entries.find { it.name == value } ?: throw IllegalArgumentException("Status inválido: $value")
        }
    }
}