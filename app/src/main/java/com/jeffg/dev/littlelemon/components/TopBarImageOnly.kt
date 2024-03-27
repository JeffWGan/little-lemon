package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jeffg.dev.littlelemon.R
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonColor

@Composable
fun TopAppBarImageOnly(
    navController: NavController? = null,
    showBackButton: Boolean? = false,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController?.popBackStack() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                tint = if (showBackButton == true) {
                    LittleLemonColor.charcoal
                } else {
                    Color.Transparent
                },
                contentDescription = "Back"

            )
        }
        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .padding(horizontal = 20.dp)
        )
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Settings,
                tint = Color.Transparent,
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarImageOnlyPreview() {
    TopAppBarImageOnly()
}
