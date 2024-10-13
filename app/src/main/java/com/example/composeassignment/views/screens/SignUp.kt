package com.example.composeassignment.views.screens

import com.example.composeassignment.views.components.CustomRadioButtonTwo
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeassignment.ui.theme.white
import com.example.composeassignment.viewmodel.SignUpVM
import com.example.composeassignment.views.components.CustomTextField
import com.example.composeassignment.views.components.RadioButtonThree

@Composable
fun SignUpForm(
    onDashBoard:()->Unit
) {
    val viewModel : SignUpVM = hiltViewModel()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 40.sp,
                fontWeight = FontWeight.W800
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField(
                text = viewModel.firstName.value,
                onTextChange = { viewModel.firstName.value = it },
                enable = true,
                label = "First Name"
            )

            CustomTextField(
                text = viewModel.lastName.value ,
                onTextChange = { viewModel.lastName.value = it },
                enable = true,
                label = "Last Name"
            )

            CustomTextField(
                text = viewModel.email.value,
                onTextChange = { viewModel.email.value = it },
                enable = true,
                label = "Email"
            )

            CustomTextField(
                text = viewModel.password.value,
                onTextChange = { viewModel.password.value = it },
                enable = true,
                label = "Password"
            )

            CustomTextField(
                text = viewModel.confirmPassword.value,
                onTextChange = { viewModel.confirmPassword.value = it },
                enable = viewModel.password.value.isNotEmpty(),
                label = "Confirm Password"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CustomRadioButtonTwo(
                    text = "Male",
                    isSelected = viewModel.gender.value == "Male",
                    onSelect = { viewModel.gender.value = "Male" }
                )
                Spacer(modifier = Modifier.width(100.dp))
                CustomRadioButtonTwo(
                    text = "Female",
                    isSelected = viewModel.gender.value == "Female",
                    onSelect = { viewModel.gender.value = "Female" }
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (viewModel.checkInput()) {
                        onDashBoard()
                        Toast.makeText(context, " Success !", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, " Failed !", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = viewModel.checkInput()
            ) {
                Text(
                    text = "Create",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        color = white,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.W800,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

    }
}
