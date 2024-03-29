package com.example.simplequotesapp.data.model

data class Quotes(
    val _id: String? = "",
    val author: String? = "",
    val authorSlug: String? = "",
    val content: String? = "",
    val dateAdded: String? = "",
    val dateModified: String? = "",
    val length: Int? = 0,
    val tags: List<String> = listOf()
)