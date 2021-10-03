package ru.llxodz.pizzahouse.activities.main.fragments.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.llxodz.pizzahouse.R


class ViewPagerFragment : Fragment() {

    private var state = 0
    private var progressCircular = 34f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        return view
    }
}
