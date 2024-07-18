package ru.kryu.catalogtest.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.kryu.catalogtest.data.network.dto.CategoryResponse
import ru.kryu.catalogtest.data.network.dto.ProductResponse
import ru.kryu.catalogtest.data.network.dto.ProductSlugResponse

interface ApiService {
    @GET("categories/-/catalog")
    suspend fun getCategories(): Response<CategoryResponse>

    @GET("products/{categorySlug}/catalog")
    suspend fun getProductSlugs(@Path("categorySlug") categorySlug: String): Response<ProductSlugResponse>

    @GET("products/{productSlug}")
    suspend fun getProducts(@Path("productSlug") productSlug: String): Response<ProductResponse>
}