package ru.llxodz.pizzahouse.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_row_category_item.view.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.api.data.ApiMenuCategory
import ru.llxodz.pizzahouse.api.data.ApiMenuItem
import ru.llxodz.pizzahouse.api.data.url

class MenuCategoryAdapter(
    private val updateRecyclerView: UpdateRecyclerView? = null,
    private var rowIndex: Int = 0
): RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder>() {

    var categories: ArrayList<ApiMenuCategory> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row_category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.frg_menu__container_category_item.setOnClickListener {
            rowIndex = position
            updateRecyclerView?.didSelectCategory(categories[position].url)
        }

        if (rowIndex == position) {
            holder.itemView.setBackgroundResource(R.drawable.bg_selected_menu_category)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.bg_unselected_menu_category)
        }
    }

    override fun getItemCount(): Int = 15

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.frg_menu__iv_image_product)
        var text = itemView.findViewById<TextView>(R.id.frg_sales__tv_title)
        var price = itemView.findViewById<TextView>(R.id.frg_menu__tv_price_product)
    }
}
