package ru.llxodz.pizzahouse.activities.fragments.main_menu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.adapters.MenuCategoryAdapter
import ru.llxodz.pizzahouse.adapters.MenuProductsAdapter

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViewMenuCategory()
        setupRecyclerViewMenuProducts()
    }

    private fun setupRecyclerViewMenuCategory() {
        val adapterCategory = MenuCategoryAdapter(requireContext(),0)
        frg_menu__rv_category_menu.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        frg_menu__rv_category_menu.adapter = adapterCategory
    }

    private fun setupRecyclerViewMenuProducts() {
        val adapterMenuProducts = MenuProductsAdapter()
        frg_menu__rv_menu_items.layoutManager = LinearLayoutManager(activity)
        frg_menu__rv_menu_items.adapter = adapterMenuProducts
    }
}
