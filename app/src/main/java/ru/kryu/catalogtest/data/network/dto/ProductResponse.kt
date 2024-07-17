package ru.kryu.catalogtest.data.network.dto

import ru.kryu.catalogtest.data.network.Response

data class ProductResponse(
    val products: List<ProductDto>
) : Response()