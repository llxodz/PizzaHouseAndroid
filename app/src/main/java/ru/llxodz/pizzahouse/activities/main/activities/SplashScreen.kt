package ru.llxodz.pizzahouse.activities.main.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.llxodz.pizzahouse.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (wasOnboarding()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun wasOnboarding(): Boolean {
        val sharedPref = getSharedPreferences("onboarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}