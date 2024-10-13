package com.example.composeassignment.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeassignment.R

@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    label: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        if (selected) {
            Icon(
                painter = painterResource(
                    id = R.drawable.radio_button_checked
                ),
                contentDescription = "marked",
                tint = Color.Blue,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Icon(
                painter = painterResource(
                    id = R.drawable.radio_button_unchecked
                ),
                contentDescription = "unmarked",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)
    }
}