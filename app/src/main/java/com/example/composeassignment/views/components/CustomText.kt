package com.example.composeassignment.views.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextField(
    text: String,
    onTextChange: (String) -> Unit,
    enable: Boolean,
    label : String
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier.fillMaxWidth(),
        enabled = enable,
        label = {
            Text(text= label)
        }
    )
}