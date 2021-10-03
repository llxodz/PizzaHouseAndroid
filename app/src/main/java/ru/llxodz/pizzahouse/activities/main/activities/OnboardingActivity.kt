package ru.llxodz.pizzahouse.activities.main.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_onboarding.*
import ru.llxodz.pizzahouse.R
import ru.llxodz.pizzahouse.activities.main.adapters.ViewPagerAdapter
import ru.llxodz.pizzahouse.activities.main.fragments.onboarding.BaseOnboardingFragment

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        setupOnboarding()
    }

    private fun setupOnboarding() {

        var state = 0
        var progressCircular = 34f

        val fragmentList = arrayListOf<Fragment>(
            BaseOnboardingFragment(0),
            BaseOnboardingFragment(1),
            BaseOnboardingFragment(2)
        )

        val adapter =
            ViewPagerAdapter(fragmentList, supportFragmentManager, lifecycle)

        vp_onboarding.adapter = adapter

        val viewPager = vp_onboarding

        viewPager.isUserInputEnabled = false

        fab_onboarding.setOnClickListener {
            if (state == 2) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                onboardingFinished()
            } else {
                viewPager.currentItem += 1
                progressCircular += 34f
                state += 1
                iv_onboarding_back.visibility = View.VISIBLE
                progress_circular.setProgressWithAnimation(progressCircular, 700)
            }
        }

        iv_onboarding_back.setOnClickListener {
            viewPager.currentItem -= 1
            progressCircular -= 34f
            state -= 1
            progress_circular.setProgressWithAnimation(progressCircular, 700)
            if (viewPager.currentItem == 0) {
                iv_onboarding_back.visibility = View.GONE
            }
        }
    }

    private fun onboardingFinished() {
        val sharedPref = getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
        finish()
    }
}