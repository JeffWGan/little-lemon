package com.jeffg.dev.littlelemon.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jeffg.dev.littlelemon.R
import com.jeffg.dev.littlelemon.data.PreferenceKey
import com.jeffg.dev.littlelemon.data.PreferencesManager

fun onRegistrationClicked(
    navController: NavController,
    firstName: String, lastName: String, emailAddress: String
) {
    val context = navController.context
    if (firstName.isBlank() || lastName.isBlank() || emailAddress.isBlank()) {
        Toast.makeText(
            context,
            "Registration unsuccessful. Please enter all data.",
            Toast.LENGTH_LONG
        ).show()
        return
    }

    val preferencesManager = PreferencesManager(context)
    preferencesManager.saveData(PreferenceKey.FirstName, firstName)
    preferencesManager.saveData(PreferenceKey.LastName, lastName)
    preferencesManager.saveData(PreferenceKey.EmailAddress, emailAddress)
    navController.navigate(Home.route) { popUpTo(0) }
}

@Composable
fun OnboardingBody(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        var firstName by remember {
            mutableStateOf("")
        }
        var lastName by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        Text(
            text = "Personal Information",
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(vertical = 40.dp)
        )
        OutlinedTextField(
            value = firstName,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                firstName = it
            },
            label = { Text("First name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        OutlinedTextField(value = lastName,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            onValueChange = {
                lastName = it
            }, label = { Text("Last name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            label = { Text("Email address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onRegistrationClicked(navController, firstName, lastName, email) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Red)
        ) {
            Text(
                text = stringResource(id = R.string.register)
            )
        }
    }
}

//@Preview
//@Composable
//fun OnboardingBodyPreview() {
//    Column(Modifier.background(Color.White)) {
////        OnboardingBody()
//    }
//
//}
