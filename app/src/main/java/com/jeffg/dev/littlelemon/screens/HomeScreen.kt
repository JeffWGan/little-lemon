package com.jeffg.dev.littlelemon.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jeffg.dev.littlelemon.MainViewModel
import com.jeffg.dev.littlelemon.components.CategoryBar
import com.jeffg.dev.littlelemon.components.MenuItems
import com.jeffg.dev.littlelemon.components.TopAppBar
import com.jeffg.dev.littlelemon.components.UpperPanel
import com.jeffg.dev.littlelemon.data.database.MenuItemRoom

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: MainViewModel = viewModel()) {

    val items by homeViewModel.getMenu().observeAsState(emptyList())

    LaunchedEffect(Unit) {
        homeViewModel.fetchMenu()
    }

    Column {
        TopAppBar(navController = navController)
        var category by remember {
            mutableStateOf("")
        }

        val categories = remember(items) {
            items.map(MenuItemRoom::category).distinct()
        }

        var searchPhrase by remember {
            mutableStateOf("")
        }

        val menuItems = remember(items, category, searchPhrase) {
            items.filterByCategory(category).filterByTitle(searchPhrase)
        }

        UpperPanel(searchPhrase) {
            searchPhrase = it
        }
        CategoryBar(
            listOf("All") + categories
        ) { category = it }
        MenuItems(navController, menuItems)
    }
}

// filter by title if phrase is not empty
private fun List<MenuItemRoom>.filterByTitle(phrase: String): List<MenuItemRoom> =
    if (phrase.isEmpty()) {
        this
    } else {
        filter {
            it.title.contains(phrase, ignoreCase = true)
        }
    }

private fun List<MenuItemRoom>.filterByCategory(category: String): List<MenuItemRoom> =
    if (category.isBlank() || category == "All") {
        this
    } else {
        filter {
            it.category.lowercase() == category.lowercase()
        }
    }
