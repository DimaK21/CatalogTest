package ru.kryu.catalogtest.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.kryu.catalogtest.data.network.NetworkClient
import ru.kryu.catalogtest.data.network.Request
import ru.kryu.catalogtest.data.network.RetrofitNetworkClient
import ru.kryu.catalogtest.data.network.dto.CategoryResponse
import ru.kryu.catalogtest.data.network.dto.ProductResponse
import ru.kryu.catalogtest.data.network.dto.ProductSlugResponse
import ru.kryu.catalogtest.data.network.mapper.mapToModel
import ru.kryu.catalogtest.data.network.mapper.mapToString
import ru.kryu.catalogtest.domain.ProductRepository
import ru.kryu.catalogtest.domain.model.Product
import ru.kryu.catalogtest.utils.Resource
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient
) : ProductRepository {
    override suspend fun getProducts(slug: String): Flow<Resource<List<Product>>> = flow {
        val response = networkClient.doRequest(Request.ProductSlugRequest(slug))
        emit(
            when (response.resultCode) {
                RetrofitNetworkClient.CODE_SUCCESS -> {
                    getProducts((response as ProductSlugResponse).productSlugs.map{it.mapToString()})
                }

                else -> {
                    Resource.Error(
                        message = ("${response.resultCode} ${response.text}")
                    )
                }
            }
        )
    }

    private suspend fun getProducts(slugs: List<String>): Resource<List<Product>> {
        val products = mutableListOf<Product>()
        for (slug in slugs) {
            val response = networkClient.doRequest(Request.ProductRequest(slug))
            if (response.resultCode == RetrofitNetworkClient.CODE_SUCCESS) {
                products.add((response as ProductResponse).product.mapToModel())
            }
        }
        return Resource.Success(products)
    }
}