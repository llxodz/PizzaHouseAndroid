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

        var progressCircular = 0f

        window.statusBarColor = ContextCompat.getColor(this, R.color.mainBackground)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.mainBackground)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val fragmentList = arrayListOf<Fragment>(
            BaseOnboardingFragment(BaseOnboardingFragment.StateOnboarding.FIRST_FRAGMENT),
            BaseOnboardingFragment(BaseOnboardingFragment.StateOnboarding.SECOND_FRAGMENT),
            BaseOnboardingFragment(BaseOnboardingFragment.StateOnboarding.THIRD_FRAGMENT)
        )

        vp_onboarding.adapter = ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)

        val viewPager = vp_onboarding

        viewPager.isUserInputEnabled = false

        // Set progress Circular Progress Bar
        progress_circular.progress =
            ((viewPager.currentItem + 1).toFloat() / fragmentList.size.toFloat()) * 100
        progressCircular =
            ((viewPager.currentItem + 1).toFloat() / fragmentList.size.toFloat()) * 100


        fab_onboarding.setOnClickListener {
            if (viewPager.currentItem >= fragmentList.lastIndex) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                onboardingFinished()
            } else {
                viewPager.currentItem += 1
                progressCircular =
                    ((viewPager.currentItem.toFloat() + 1) / fragmentList.size.toFloat()) * 100
                iv_onboarding_back.visibility = View.VISIBLE
                progress_circular.setProgressWithAnimation(progressCircular, 300)
            }
        }

        iv_onboarding_back.setOnClickListener {
            viewPager.currentItem -= 1
            progressCircular =
                ((viewPager.currentItem.toFloat() + 1) / fragmentList.size.toFloat()) * 100
            progress_circular.setProgressWithAnimation(progressCircular, 300)
            if (viewPager.currentItem == 0) {
                iv_onboarding_back.visibility = View.GONE
            }
        }
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
