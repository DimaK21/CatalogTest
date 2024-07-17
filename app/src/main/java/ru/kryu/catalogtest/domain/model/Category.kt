package ru.kryu.catalogtest.domain.model

data class Category(
    val title: String,
    val slug: String,
    val depth: Int,
    val icon: String,
    val description: String?,
    val subCategories: List<Category>
)
