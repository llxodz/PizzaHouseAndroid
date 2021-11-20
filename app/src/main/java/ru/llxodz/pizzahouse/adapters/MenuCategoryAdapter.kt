package ru.llxodz.pizzahouse.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_row_category_item.view.*
import ru.llxodz.pizzahouse.R

class MenuCategoryAdapter(private val context: Context, private var rowIndex: Int) :
    RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row_category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.frg_menu__container_category_item.setOnClickListener {
            rowIndex = position
            notifyDataSetChanged()
        }

        if (rowIndex == position) {
            holder.itemView.setBackgroundResource(R.drawable.bg_selected_menu_category)
        } else {
            holder.itemView.setBackgroundResource(R.drawable.bg_unselected_menu_category)
        }
    }

    override fun getItemCount(): Int = 15

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
