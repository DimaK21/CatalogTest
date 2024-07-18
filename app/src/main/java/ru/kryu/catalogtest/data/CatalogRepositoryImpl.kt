package ru.kryu.catalogtest.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.kryu.catalogtest.data.network.NetworkClient
import ru.kryu.catalogtest.data.network.Request
import ru.kryu.catalogtest.data.network.RetrofitNetworkClient
import ru.kryu.catalogtest.data.network.dto.CategoryResponse
import ru.kryu.catalogtest.data.network.mapper.mapToModel
import ru.kryu.catalogtest.domain.CatalogRepository
import ru.kryu.catalogtest.domain.model.Category
import ru.kryu.catalogtest.utils.Resource
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient
) : CatalogRepository {
    override suspend fun getCategories(): Flow<Resource<List<Category>>> = flow {
        val response = networkClient.doRequest(Request.CategoryRequest)
        emit(
            when (response.resultCode) {
                RetrofitNetworkClient.CODE_SUCCESS -> {
                    Resource.Success((response as CategoryResponse).categories.map { it.mapToModel() })
                }

                else -> {
                    Resource.Error(
                        message = ("${response.resultCode} ${response.text}")
                    )
                }
            }
        )
    }
}
