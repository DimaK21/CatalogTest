package ru.kryu.catalogtest.data.network.dto

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Int,
    val title: String,
    val slug: String,
    val rating: Rating,
    val sku: Int,
    val units: String,
    val description: String,
    @SerializedName("use_other_description")
    val useOtherDescription: Int,
    val brand: String,
    val measure: Measure,
    val purchase: Purchase,
    @SerializedName("category_slug")
    val categorySlug: String,
    @SerializedName("category_title")
    val categoryTitle: String,
    val images: List<Image>,
    val weight: String,
    @SerializedName("order_days")
    val orderDays: String,
    val bonus: Int,
    val additionals: Additionals
)

data class Rating(
    val stars: Stars,
    val count: Int,
    val avg: String
) {
    data class Stars(
        @SerializedName("1")
        val x1: Int,
        @SerializedName("2")
        val x2: Int,
        @SerializedName("3")
        val x3: Int,
        @SerializedName("4")
        val x4: Int,
        @SerializedName("5")
        val x5: Int
    )
}

data class Measure(
    val code: Int,
    val min: Int,
    val inc: Int
)

data class Purchase(
    @SerializedName("base_id")
    val baseId: Int,
    @SerializedName("count_available")
    val countAvailable: Int,
    val price: Int,
    @SerializedName("price_old")
    val priceOld: Int,
    @SerializedName("size_discount")
    val sizeDiscount: Int,
    @SerializedName("card_discount")
    val cardDiscount: Boolean,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("product_slug")
    val productSlug: String
)

data class Image(
    val original: String
)

data class Additionals(
    @SerializedName("is_linoleum")
    val isLinoleum: Boolean,
    @SerializedName("is_kovrolin")
    val isKovrolin: Boolean,
    @SerializedName("second_units")
    val secondUnits: Any?,
    @SerializedName("second_price")
    val secondPrice: Any?,
    @SerializedName("second_price_old")
    val secondPriceOld: Any?,
    @SerializedName("second_prop_value")
    val secondPropValue: Any?,
    @SerializedName("is_egais")
    val isEgais: Boolean
)
