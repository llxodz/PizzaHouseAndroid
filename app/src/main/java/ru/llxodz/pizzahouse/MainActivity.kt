package ru.llxodz.pizzahouse

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferences: SharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)

        if(!preferences.getBoolean("onboarding_complete",false)){
    }
}
