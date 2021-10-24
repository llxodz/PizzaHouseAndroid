package ru.llxodz.pizzahouse.activities.main.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sales_row_item.view.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.activities.main.helper.Constants

class SalesAdapter : RecyclerView.Adapter<SalesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.sales_row_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 4
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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