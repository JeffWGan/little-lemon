package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeffg.dev.littlelemon.R
import com.jeffg.dev.littlelemon.ui.theme.LittleLemonColor
import com.jeffg.dev.littlelemon.ui.theme.Shapes

@Composable
fun UpperPanel(searchPhrase: String, onSearchPhraseChanged: (String) -> Unit) {
    Column(
        modifier = Modifier
            .background(color = LittleLemonColor.green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)

    ) {
        Text(
            text = stringResource(id = R.string.title),
            style = MaterialTheme.typography.h1,
        )
        Text(
            text = stringResource(id = R.string.location),
            style = MaterialTheme.typography.h2,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 16.dp)
                    .fillMaxWidth(0.6f),
                color = LittleLemonColor.cloud
            )
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        OutlinedTextField(
            textStyle = MaterialTheme.typography.subtitle1,
            value = searchPhrase,
            onValueChange = onSearchPhraseChanged,
            placeholder = {
                Text(text = "Enter Search Phrase")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search dish"
                )
            },
            trailingIcon = {
                Icon(Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier
                        .clickable {
                            onSearchPhraseChanged("")
                        }
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.background,
                cursorColor = LittleLemonColor.charcoal,
                textColor = LittleLemonColor.charcoal,
                focusedLabelColor = LittleLemonColor.charcoal,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .clip(Shapes.medium)
                .background(LittleLemonColor.cloud),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    UpperPanel("") {}
}
