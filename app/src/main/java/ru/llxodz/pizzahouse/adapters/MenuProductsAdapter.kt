package ru.llxodz.pizzahouse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_row_product_item.view.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.api.data.ApiMenuItem

class MenuProductsAdapter(private val items: ArrayList<ApiMenuItem>) :
    RecyclerView.Adapter<MenuProductsAdapter.MenuProductsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuProductsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row_product_item, parent, false)
        return MenuProductsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuProductsViewHolder, position: Int) {
        holder.itemView.frg_menu__tv_price_product.text = items[position].price.toString()
        holder.itemView.frg_menu__tv_name_product.text = items[position].name
        holder.itemView.frg_menu__iv_image_product.setImageResource(items[position].image)
    }

    override fun getItemCount(): Int = items.size

    class MenuProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}