package com.example.littlelemon.data

import com.jeffg.dev.littlelemon.data.MenuItemRoom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

const val LITTLE_LEMON_URL =
    "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"

@Serializable
data class MenuNetwork(
    @SerialName("menu")
    val menu: List<MenuItemNetwork>,
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("price")
    val price: Double,
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id,
        title,
        price
    )
}
