package ru.kryu.catalogtest.data.network.mapper

import ru.kryu.catalogtest.data.network.dto.CategoryDto
import ru.kryu.catalogtest.data.network.dto.ProductDto
import ru.kryu.catalogtest.data.network.dto.ProductSlugDto
import ru.kryu.catalogtest.domain.model.Category
import ru.kryu.catalogtest.domain.model.Product

fun CategoryDto.mapToModel(): Category {
    return Category(
        title = title,
        slug = slug,
        depth = depth,
        icon = icon,
        description = description,
        subCategories = subCategories.map { it.mapToModel() }
    )
}

fun ProductDto.mapToModel(): Product {
    return Product(
        id = id,
        title = title,
        slug = slug,
        sku = sku,
        units = units,
        description = description,
        brand = brand,
        price = purchase.price,
        priceOld = purchase.priceOld,
        sizeDiscount = purchase.sizeDiscount,
        categorySlug = categorySlug,
        categoryTitle = categoryTitle,
        images = images.map { it.original },
    )
}

fun ProductSlugDto.mapToString(): String = slug
