package ru.llxodz.pizzahouse.activities.main.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_onboarding.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.activities.main.adapters.ViewPagerAdapter
import ru.llxodz.pizzahouse.activities.main.fragments.onboarding.BaseOnboardingFragment
import ru.llxodz.pizzahouse.activities.main.helper.Constants

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        setupOnboarding()
    }

    private fun setupOnboarding() {

        var progressCircular = 34f

        window.statusBarColor = ContextCompat.getColor(this, R.color.mainBackground)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.mainBackground)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val fragmentList = arrayListOf<Fragment>(
            BaseOnboardingFragment(StateOnboarding.FIRST_FRAGMENT.state),
            BaseOnboardingFragment(StateOnboarding.SECOND_FRAGMENT.state),
            BaseOnboardingFragment(StateOnboarding.THIRD_FRAGMENT.state)
        )

        val adapter =
            ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)

        vp_onboarding.adapter = adapter

        val viewPager = vp_onboarding

        viewPager.isUserInputEnabled = false

        fab_onboarding.setOnClickListener {
            if (viewPager.currentItem == StateOnboarding.THIRD_FRAGMENT.state) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                onboardingFinished()
            } else {
                viewPager.currentItem += StateOnboarding.BASE_STEP.state
                progressCircular += 100 / 3
                iv_onboarding_back.visibility = View.VISIBLE
                progress_circular.setProgressWithAnimation(progressCircular, 300)
            }
        }

        iv_onboarding_back.setOnClickListener {
            viewPager.currentItem -= StateOnboarding.BASE_STEP.state
            progressCircular -= 100 / 3
            progress_circular.setProgressWithAnimation(progressCircular, 300)
            if (viewPager.currentItem == 0) {
                iv_onboarding_back.visibility = View.GONE
            }
        }
    }

    private enum class StateOnboarding(val state: Int) {
        FIRST_FRAGMENT(0), SECOND_FRAGMENT(1), THIRD_FRAGMENT(2), BASE_STEP(1)
    }

    private fun onboardingFinished() {
        val sharedPref =
            getSharedPreferences(Constants.ru_llxodz_pizzahouse_onboarding, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(Constants.ru_llxodz_pizzahouse_onboarding_state, true)
        editor.apply()
        finish()
    }
}