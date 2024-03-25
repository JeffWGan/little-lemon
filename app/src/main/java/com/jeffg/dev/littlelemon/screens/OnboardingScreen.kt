package com.jeffg.dev.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jeffg.dev.littlelemon.components.OnboardingBody
import com.jeffg.dev.littlelemon.components.OnboardingSubHeader
import com.jeffg.dev.littlelemon.components.TopAppBarImageOnly

@Composable
fun OnboardingScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxHeight()) {
        TopAppBarImageOnly()
        OnboardingSubHeader()
        OnboardingBody()

    }
}
