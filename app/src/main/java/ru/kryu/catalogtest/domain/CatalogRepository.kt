package ru.kryu.catalogtest.domain

import kotlinx.coroutines.flow.Flow
import ru.kryu.catalogtest.domain.model.Category
import ru.kryu.catalogtest.utils.Resource

interface CatalogRepository {
    fun getCategories(): Flow<Resource<List<Category>>>
}