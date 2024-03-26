package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.jeffg.dev.littlelemon.data.database.MenuItemRoom
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonColor

@Composable
fun MenuItems(
    navController: NavHostController,
    menuItems: List<MenuItemRoom>,
) {
    Column {
        Divider(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            thickness = 1.dp,
            color = Color.Gray,
        )
        LazyColumn {
            items(
                count = menuItems.size,
                key = { menuItems[it].id },
                itemContent = { index ->
                    val dish = menuItems[index]
                    MenuDish(navController, dish)
                    Divider(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                        thickness = 1.dp,
                        color = LittleLemonColor.yellow,
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: MenuItemRoom) {
    Card(onClick = {
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(Modifier.padding(end = 8.dp)) {
                Text(
                    text = dish.title,
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .padding(vertical = 8.dp)
                )
                Text(
                    text = "$${dish.price}",
                    style = MaterialTheme.typography.body2
                )
            }
            GlideImage(
                model = dish.imageUrl,
                contentDescription = dish.title,
                modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                )
            )
        }
    }
}
