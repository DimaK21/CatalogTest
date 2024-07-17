package ru.kryu.catalogtest.data.network

sealed interface Request{
    class CategoryRequest : Request
    data class ProductRequest(val slug: String) : Request
    data class ProductSlugRequest(val slug: String) : Request
}