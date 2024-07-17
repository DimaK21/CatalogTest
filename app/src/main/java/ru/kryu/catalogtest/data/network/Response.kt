package ru.kryu.catalogtest.data.network

import ru.kryu.catalogtest.data.network.dto.CategoryDto
import ru.kryu.catalogtest.data.network.dto.ProductDto
import ru.kryu.catalogtest.data.network.dto.ProductSlugDto

open class Response {
    var resultCode = 0
    var text: String? = null
}