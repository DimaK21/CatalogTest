package ru.kryu.catalogtest.domain

import kotlinx.coroutines.flow.Flow
import ru.kryu.catalogtest.domain.model.Product
import ru.kryu.catalogtest.utils.Resource

interface ProductRepository {
    fun getProducts(slug: String): Flow<Resource<List<Product>>>
}