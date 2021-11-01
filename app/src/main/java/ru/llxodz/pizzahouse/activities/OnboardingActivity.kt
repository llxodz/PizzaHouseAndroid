package ru.llxodz.pizzahouse.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_onboarding.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.adapters.ViewPagerAdapter
import ru.llxodz.pizzahouse.activities.fragments.onboarding_fragments.BaseOnboardingFragment
import ru.llxodz.pizzahouse.helper.Constants

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
        progress_circular.progress = setProgressCircular(viewPager, fragmentList)
        progressCircular = setProgressCircular(viewPager, fragmentList)


        fab_onboarding.setOnClickListener {
            if (viewPager.currentItem >= fragmentList.lastIndex) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                onboardingFinished()
            } else {
                viewPager.currentItem += 1
                progressCircular = setProgressCircular(viewPager, fragmentList)
                iv_onboarding_back.visibility = View.VISIBLE
                progress_circular.setProgressWithAnimation(progressCircular, 300)
            }
        }

        iv_onboarding_back.setOnClickListener {
            viewPager.currentItem -= 1
            progressCircular = setProgressCircular(viewPager, fragmentList)
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

    private fun setProgressCircular(
        viewPager: ViewPager2,
        fragmentList: ArrayList<Fragment>
    ): Float {
        return ((viewPager.currentItem + 1).toFloat() / fragmentList.size.toFloat()) * 100
    }
}
