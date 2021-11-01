package ru.llxodz.pizzahouse.activities.main.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.llxodz.pizzahouse.activities.main.helper.Constants

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences =
            getSharedPreferences(Constants.ru_llxodz_piz zahouse_onboarding, Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean(Constants.ru_llxodz_pizzahouse_onboarding_state, false)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
