package com.jeffg.dev.littlelemon.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MenuItemRoom(
    @PrimaryKey val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    val category: String,
)
