package ru.llxodz.pizzahouse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.menu_row_category_item.view.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.api.ApiMenuCategory

class MenuCategoryAdapter(
    private val menuCategoryList: List<ApiMenuCategory>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row_category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = menuCategoryList[position]

        holder.itemView.frg_menu__iv_picture_category.setImageResource(currentItem.image)
        holder.itemView.frg_menu__tv_category_menu.text = currentItem.name
    }

    override fun getItemCount(): Int = menuCategoryList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            notifyDataSetChanged()
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}