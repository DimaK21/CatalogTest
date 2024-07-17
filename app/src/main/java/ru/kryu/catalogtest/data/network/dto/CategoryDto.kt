package ru.kryu.catalogtest.data.network.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    val title: String,
    @SerializedName("seo_title")
    val seoTitle: String?,
    val slug: String,
    val depth: Int,
    val icon: String,
    @SerializedName("webp_icon")
    val webpIcon: String,
    val description: String?,
    @SerializedName("seo_description")
    val seoDescription: String?,
    @SerializedName("banner_image")
    val bannerImage: String?,
    @SerializedName("banner_mobile_image")
    val bannerMobileImage: String?,
    @SerializedName("banner_href")
    val bannerHref: String?,
    val subCategories: List<CategoryDto>
)