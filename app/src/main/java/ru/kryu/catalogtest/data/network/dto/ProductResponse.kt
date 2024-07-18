package ru.kryu.catalogtest.data.network.dto

import ru.kryu.catalogtest.data.network.Response

data class ProductResponse(
    val product: ProductDto
) : Response()