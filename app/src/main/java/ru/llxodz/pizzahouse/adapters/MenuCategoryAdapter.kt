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
import ru.llxodz.pizzahouse.api.data.ApiMenuItem

class MenuCategoryAdapter(
    private val context: Context,
    private var rowIndex: Int,
    private val updateRecyclerView: UpdateRecyclerView,
    private var check: Boolean = true
) :
    RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_row_category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (check) {
            val items = ArrayList<ApiMenuItem>()
            items.add(ApiMenuItem(1, "Пеперони", R.drawable.pizza_name_delete, 400))
            items.add(ApiMenuItem(2, "Пеперони", R.drawable.pizza_name_delete, 400))
            items.add(ApiMenuItem(3, "Пеперони", R.drawable.pizza_name_delete, 400))
            items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 400))

            updateRecyclerView.callback(position, items)

            check = false
        }

        holder.itemView.frg_menu__container_category_item.setOnClickListener {
            rowIndex = position
            notifyDataSetChanged()

            when (position) {
                0 -> {
                    val items = ArrayList<ApiMenuItem>()
                    items.add(ApiMenuItem(1, "Пеперони", R.drawable.pizza_name_delete, 400))
                    items.add(ApiMenuItem(2, "Пеперони", R.drawable.pizza_name_delete, 400))
                    items.add(ApiMenuItem(3, "Пеперони", R.drawable.pizza_name_delete, 400))
                    items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
                    items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
                    items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
                    updateRecyclerView.callback(position, items)
                }
                1 -> {
                    val items = ArrayList<ApiMenuItem>()
                    items.add(ApiMenuItem(1, "Шаверма", R.drawable.ic_baseline_chevron_left_24, 400))
                    items.add(ApiMenuItem(2, "Шаверма", R.drawable.ic_baseline_chevron_left_24, 400))
                    items.add(ApiMenuItem(3, "Шаверма", R.drawable.ic_baseline_chevron_left_24, 400))
                    items.add(ApiMenuItem(4, "Шаверма", R.drawable.ic_baseline_chevron_left_24, 400))
                    updateRecyclerView.callback(position, items)
                }
            }
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
