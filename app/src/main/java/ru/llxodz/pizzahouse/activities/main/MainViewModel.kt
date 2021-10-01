package ru.llxodz.pizzahouse.activities.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import ru.llxodz.pizzahouse.BackViewModel
import ru.llxodz.pizzahouse.helper.CiceroneHelper
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainViewModel(private val router: Router) : BackViewModel(router), LifecycleObserver {

    private lateinit var navigator: SupportAppNavigator
    private val navHolder = CiceroneHelper.navHolder()

    fun navigateToOnBoardingScreen() {

    }

    fun setNavigator(navigator: SupportAppNavigator) {
        this.navigator = navigator
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun setNavigator() {
        navHolder.setNavigator(navigator)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun removeNavigator() {
        navHolder.removeNavigator()
    }
}
