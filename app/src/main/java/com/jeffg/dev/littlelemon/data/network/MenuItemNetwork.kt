package com.jeffg.dev.littlelemon.data.network

import com.jeffg.dev.littlelemon.data.database.MenuItemRoom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("price")
    val price: Double,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val imageUrl: String,
    @SerialName("category")
    val category: String,
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id,
        title,
        price,
        description,
        imageUrl,
        category
    )
}
