package com.kotlin.blog.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    // @field:NotBlank(message = "name")
    val name: String,
    val email: String,
    val password: String
)
