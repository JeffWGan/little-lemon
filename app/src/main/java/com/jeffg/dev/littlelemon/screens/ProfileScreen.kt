package com.jeffg.dev.littlelemon.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jeffg.dev.littlelemon.components.ProfileBody
import com.jeffg.dev.littlelemon.components.TopAppBarImageOnly

@Composable
fun ProfileScreen(navController: NavController) {
    TopAppBarImageOnly()
    ProfileBody(navController = navController)
}
