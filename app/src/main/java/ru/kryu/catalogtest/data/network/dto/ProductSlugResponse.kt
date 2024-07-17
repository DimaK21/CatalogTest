package ru.kryu.catalogtest.data.network.dto

import ru.kryu.catalogtest.data.network.Response

data class ProductSlugResponse(
    val productSlugs: List<ProductSlugDto>
) : Response()
