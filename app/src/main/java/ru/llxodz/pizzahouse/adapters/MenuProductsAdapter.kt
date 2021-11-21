package ru.llxodz.pizzahouse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.llxodz.pizzahouse.R

class MenuProductsAdapter: RecyclerView.Adapter<MenuProductsAdapter.MenuProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.menu_row_product_item, parent, false)
        return MenuProductsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuProductsViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 10

    class MenuProductsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}