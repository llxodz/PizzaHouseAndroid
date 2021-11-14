package ru.llxodz.pizzahouse.activities.fragments.main_menu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.adapters.MenuCategoryAdapter
import ru.llxodz.pizzahouse.api.ApiMenuCategory
import ru.llxodz.pizzahouse.helper.Helper

class MenuFragment : Fragment(), MenuCategoryAdapter.OnItemClickListener {

    private val exampleList = Helper.generateMenuCategoryList(12)
    private val adapter = MenuCategoryAdapter(exampleList, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        frg_menu__rv_category_menu.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        frg_menu__rv_category_menu.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val clickedItem: ApiMenuCategory = exampleList[position]
//        clickedItem.image = R.drawable.pizza
        adapter.notifyItemChanged(position)
    }
}
