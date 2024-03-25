package com.jeffg.dev.littlelemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jeffg.dev.littlelemon.R
import com.jeffg.dev.littlelemon.data.PreferenceKey
import com.jeffg.dev.littlelemon.data.PreferencesManager

fun onLogoutClicked(navController: NavController) {
    val preferencesManager = PreferencesManager(navController.context)
    preferencesManager.clearData()
    navController.navigate(Onboarding.route) { popUpTo(0) }
}

@Composable
fun ProfileBody(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        val preferencesManager = remember { PreferencesManager(navController.context) }
        var firstName by remember {
            mutableStateOf(preferencesManager.getData(PreferenceKey.FirstName, ""))
        }
        var lastName by remember {
            mutableStateOf(preferencesManager.getData(PreferenceKey.LastName, ""))
        }
        var email by remember {
            mutableStateOf(preferencesManager.getData(PreferenceKey.EmailAddress, ""))
        }
        Text(
            text = "Personal Information",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(vertical = 40.dp)
        )
        OutlinedTextField(
            value = firstName,
            enabled = false,
            onValueChange = {},
            label = { Text("First name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        OutlinedTextField(
            value = lastName,
            enabled = false,
            onValueChange = {},
            label = { Text("Last name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        OutlinedTextField(
            value = email,
            enabled = false,
            onValueChange = {},
            label = { Text("Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onLogoutClicked(navController) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.log_out)
            )
        }
    }
}
