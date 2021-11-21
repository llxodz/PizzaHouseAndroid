package ru.llxodz.pizzahouse.adapters

import ru.llxodz.pizzahouse.api.data.ApiMenuItem

interface UpdateRecyclerView {
    fun callback(position: Int, items: ArrayList<ApiMenuItem>)
}