package ru.llxodz.pizzahouse.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.sales_row_item.view.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.helper.Constants
import ru.llxodz.pizzahouse.api.data.ApiSalesItem

class SalesAdapter(
    private var context: Context,
    private var items: List<ApiSalesItem>
) : RecyclerView.Adapter<SalesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.sales_row_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        holder.promoCode.text = items[position].promocode

        Glide.with(context).load("${Constants.BASE_URL}/file/${items[position].image}").into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.frg_sales__tv_title
        var description = itemView.frg_sales__tv_description
        var image = itemView.frg_sales__iv_pizza
        var promoCode = itemView.frg_sales_tv_promoCode_name

        fun bind() {
            itemView.frg_sales_btn_promoCode.setOnClickListener {
                val clipboard =
                    itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clip = ClipData.newPlainText(
                    Constants.ru_llxodz_pizzahouse_sales_promocode,
                    itemView.frg_sales_tv_promoCode_name.text
                )
                clipboard?.setPrimaryClip(clip)

                Toast.makeText(
                    itemView.context,
                    itemView.context.getString(R.string.copy_promocode),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
