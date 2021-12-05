package ru.llxodz.pizzahouse.api.data

import java.net.URL

data class ApiMenuCategory(
    var id: Int,
    var name: String,
    var image: Int
)

val ApiMenuCategory.url: URL
    get() {
        return URL(this.id.toString())
    }