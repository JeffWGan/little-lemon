package com.jeffg.dev.littlelemon.components

interface Destinations {
    val route: String
}

object Onboarding : Destinations {
    override val route = "Onboarding"
}

object Home : Destinations {
    override val route = "Home"
}

object MyProfile : Destinations {
    override val route = "MyProfile"
}

object DishDetails : Destinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}
