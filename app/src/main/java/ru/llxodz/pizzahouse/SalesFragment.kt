package ru.llxodz.pizzahouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sales.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.llxodz.pizzahouse.activities.main.adapters.SalesAdapter
import ru.llxodz.pizzahouse.activities.main.helper.Constants
import ru.llxodz.pizzahouse.api.ApiRequest
import ru.llxodz.pizzahouse.api.ApiSalesItem


class SalesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeApiRequest()

        frg_sales__tv_restart_request.setOnClickListener {
            makeApiRequest()
            frg_sales__tv_restart_request.visibility = View.GONE
            frg_sales_tv_exception.visibility = View.GONE
            frg_sales_lazy_loader.visibility = View.VISIBLE
        }
    }

    private fun makeApiRequest() {
        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(ApiRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val items = api.getPromoCodes().body()
                if (items != null) {
                    if (items.isNotEmpty()) {
                        withContext(Dispatchers.Main) {
                            setupRecyclerView(items)
                            frg_sales_lazy_loader.visibility = View.GONE
                        }
                    } else {
                        // Is empty List
                        withContext(Dispatchers.Main) {
                            frg_sales_lazy_loader.visibility = View.GONE
                            frg_sales_tv_exception.text =
                                getString(R.string.tv_exception_null_sales)
                            frg_sales_tv_exception.visibility = View.VISIBLE
                        }
                    }
                } else {
                    // Is error Request
                    withContext(Dispatchers.Main) {
                        errorRequest()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    errorRequest()
                }
            }
        }
    }

    private fun setupRecyclerView(items: List<ApiSalesItem>) {
        frg_sales__rv_sales.layoutManager = LinearLayoutManager(activity)
        frg_sales__rv_sales.adapter =
            SalesAdapter(
                requireContext(),
                items
            )
    }

    private fun errorRequest() {
        frg_sales_lazy_loader.visibility = View.GONE
        frg_sales_tv_exception.text = getString(R.string.tv_exception)
        frg_sales_tv_exception.visibility = View.VISIBLE
        frg_sales__tv_restart_request.visibility = View.VISIBLE
    }
}
