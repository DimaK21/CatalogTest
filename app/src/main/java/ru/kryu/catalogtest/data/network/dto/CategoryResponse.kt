package ru.kryu.catalogtest.data.network.dto

import ru.kryu.catalogtest.data.network.Response

data class CategoryResponse(
    val categories: List<CategoryDto>
) : Response()
