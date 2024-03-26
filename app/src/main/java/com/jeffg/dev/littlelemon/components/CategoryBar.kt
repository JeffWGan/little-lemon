package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeffg.dev.littlelemon.R
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonColor

@Composable
fun CategoryButton(category: String, selectedCategory: (sel: String) -> Unit) {
    Button(
        onClick = {
            selectedCategory(category)
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = LittleLemonColor.green,
            backgroundColor = LittleLemonColor.pink
        )
    ) {
        Text(text = category.replaceFirstChar { it.uppercase() })
    }
}

@Composable
fun CategoryBar(categories: List<String>, onCategoryChanged: (String) -> Unit) {
    Card(elevation = 10.dp, modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            Text(
                text = stringResource(id = R.string.order_for_delivery).uppercase(),
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categories) { it ->
                    CategoryButton(category = it, selectedCategory = { item ->
                        onCategoryChanged(item)
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun CategoryBarPreview() {
    CategoryBar(categories = listOf("All", "Starters"), onCategoryChanged = {})
}


