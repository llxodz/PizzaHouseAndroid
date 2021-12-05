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
import ru.llxodz.pizzahouse.adapters.UpdateRecyclerView
import ru.llxodz.pizzahouse.api.data.ApiMenuItem
import java.net.URL

class MenuFragment : Fragment(), UpdateRecyclerView {

    private val items = ArrayList<ApiMenuItem>()
    private var adapterCategory = MenuCategoryAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        items.add(ApiMenuItem(1, "Пепперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(2, "Пепперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(3, "Пепперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(4, "Пепперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(5, "Пепперони", R.drawable.pizza_name_delete, 400))

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerViews
        setupRecyclerViewMenuCategory()
        setupRecyclerViewMenuProducts()

        // LoadData
//        epi.categoryes { newcategories in
        adapterCategory.categories = 
    }

    private fun setupRecyclerViewMenuCategory() {
        frg_menu__rv_category_menu.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        frg_menu__rv_category_menu.adapter = adapterCategory
    }

    private fun setupRecyclerViewMenuProducts() {
        val adapterMenuProducts = MenuProductsAdapter(items)
        frg_menu__rv_menu_items.layoutManager = LinearLayoutManager(activity)
        frg_menu__rv_menu_items.adapter = adapterMenuProducts
    }

//    override fun callback(position: Int, items: ArrayList<ApiMenuItem>) {
//        val adapter = MenuProductsAdapter(items)
//        adapter.notifyDataSetChanged()
//        frg_menu__rv_menu_items.adapter = adapter
//    }

    override fun didSelectCategory(url: URL) {
        // TODO: this
        // run indicator loader
//        API.getitems() { //callback newitems in
        val items = ArrayList<ApiMenuItem>()
        items.add(ApiMenuItem(1, "Пеперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(2, "Пеперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(3, "Пеперони", R.drawable.pizza_name_delete, 400))
        items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
        items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
        items.add(ApiMenuItem(4, "Пеперони", R.drawable.pizza_name_delete, 500))
//            frg_menu__rv_menu_items.adapter.fetrch(data: newitems)
//        }
        // stop indicator
    }
}
