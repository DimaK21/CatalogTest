package ru.kryu.catalogtest.domain.model

data class Product(
    val id: Int,
    val title: String,
    val slug: String,
    val sku: Int,
    val units: String,
    val description: String,
    val brand: String,
    val price: Int,
    val priceOld: Int,
    val sizeDiscount: Int,
    val categorySlug: String,
    val categoryTitle: String,
    val images: List<String>,
)
