package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonColor

@Composable
fun OnboardingSubHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = LittleLemonColor.green)
    ) {
        Text(
            text = "Let's get to know you",
            style = MaterialTheme.typography.h5,
            color = LittleLemonColor.cloud,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp, horizontal = 24.dp)
        )
    }
}

@Preview
@Composable
fun OnboardingPreview() {
    OnboardingSubHeader()
}
