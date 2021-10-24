package ru.llxodz.pizzahouse

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sales.*
import kotlinx.android.synthetic.main.sales_row_item.*
import ru.llxodz.pizzahouse.activities.main.adapters.SalesAdapter


class SalesFragment : Fragment() {

    private var btn = frg_sales_btn_promoCode

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        frg_sales__rv_sales.layoutManager = LinearLayoutManager(activity)
        frg_sales__rv_sales.adapter = SalesAdapter()
    }
}
