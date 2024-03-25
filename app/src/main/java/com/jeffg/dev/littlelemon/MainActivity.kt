package com.jeffg.dev.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jeffg.dev.littlelemon.components.DishDetails
import com.jeffg.dev.littlelemon.components.Home
import com.jeffg.dev.littlelemon.components.Onboarding
import com.jeffg.dev.littlelemon.screens.HomeScreen
import com.jeffg.dev.littlelemon.screens.OnboardingScreen
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

//    suspend fun greeting(): String {
//        val response: MenuNetwork = client.get(URL).body()
//        return response.bodyAsText()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Onboarding.route) {
                    composable(Onboarding.route) {
                        OnboardingScreen(navController)
                    }
                    composable(Home.route) {
                        HomeScreen(navController)
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
        }
    }
}
