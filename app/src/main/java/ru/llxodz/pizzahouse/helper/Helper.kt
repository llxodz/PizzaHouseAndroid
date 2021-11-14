package ru.llxodz.pizzahouse.helper

import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.api.ApiMenuCategory

object Helper {
    fun generateMenuCategoryList(size: Int): List<ApiMenuCategory> {
        val list = ArrayList<ApiMenuCategory>()

        for (i in 0 until size) {
            val drawable = when (i % 2) {
                0 -> R.drawable.roll
                1 -> R.drawable.fast_food
                else -> R.drawable.ic_menu
            }

            val item = ApiMenuCategory(i, "$i", drawable)
            list += item
        }
        return list
    }
}
