package com.jeffg.dev.littlelemon.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jeffg.dev.littlelemon.data.PreferenceKey
import com.jeffg.dev.littlelemon.data.PreferencesManager
import com.jeffg.dev.littlelemon.screens.HomeScreen
import com.jeffg.dev.littlelemon.screens.OnboardingScreen
import com.jeffg.dev.littlelemon.screens.ProfileScreen

@Composable
fun MyNavigation(navController: NavHostController) {
    val preferencesManager = remember { PreferencesManager(navController.context) }
    val userEmail =
        remember { mutableStateOf(preferencesManager.getData(PreferenceKey.EmailAddress, "")) }

    var startDestination by remember { mutableStateOf(Onboarding.route) }

    if (userEmail.value.isNotEmpty()) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(MyProfile.route) {
            ProfileScreen(navController)
        }
        composable(
            DishDetails.route + "/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) {
                type = NavType.IntType
            })
        ) {
            val id =
                requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
            DishDetails(id)
        }
    }
}
