package com.jeffg.dev.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jeffg.dev.littlelemon.components.DishRepository
import com.jeffg.dev.littlelemon.components.LowerPanel
import com.jeffg.dev.littlelemon.components.TopAppBar
import com.jeffg.dev.littlelemon.components.UpperPanel

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        TopAppBar()
        UpperPanel()
        LowerPanel(navController, DishRepository.dishes)
    }
}
