package ru.llxodz.pizzahouse.activities.main.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_base_onboarding.*
import ru.llxodz.pizzahouse.R

class BaseOnboardingFragment(private val state: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_base_onboarding, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (state) {
            0 -> {
                iv_onboarding_image.setImageResource(R.drawable.onboarding_image_one)
                tv_onboarding_title.text = "ЗАКАЗ ОНЛАЙН"
                tv_onboarding_description.text =
                    "Совершить заказ онлайнСовершить заказ онлайнСовершить заказ онлайн"
            }
            1 -> {
                iv_onboarding_image.setImageResource(R.drawable.onboarding_image_two)
                tv_onboarding_title.text = "ВКУСНАЯ ПИЦЦА"
                tv_onboarding_description.text =
                    "Совершить заказ онлайнСовершить заказ онлайнСовершить заказ онлайн"
            }
            2 -> {
                iv_onboarding_image.setImageResource(R.drawable.onboarding_image_third)
                tv_onboarding_title.text = "БЕСПЛАТНАЯ ДОСТАВКА"
                tv_onboarding_description.text =
                    "Совершить заказ онлайнСовершить заказ онлайнСовершить заказ онлайн"
            }
        }
    }
}
