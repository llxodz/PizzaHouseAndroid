package ru.llxodz.pizzahouse.activities.main.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.*
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sales_row_item.*
import ru.llxodz.pizzahouse.R
import androidx.appcompat.app.AppCompatActivity.CLIPBOARD_SERVICE as CLIPBOARD_SERVICE1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)

        bottom_navigation_view.setupWithNavController(navController)

        window.statusBarColor = ContextCompat.getColor(this, R.color.mainBackground)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}
