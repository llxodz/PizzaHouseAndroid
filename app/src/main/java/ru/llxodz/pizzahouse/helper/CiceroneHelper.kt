package ru.llxodz.pizzahouse.helper

import ru.llxodz.pizzahouse.app.App
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


object CiceroneHelper {
    @JvmStatic
    fun router(): Router = App.getInstance().router()
    @JvmStatic
    fun navHolder(): NavigatorHolder = App.getInstance().navigatorHolder()!!
}
