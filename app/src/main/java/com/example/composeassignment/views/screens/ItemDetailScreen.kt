package com.example.composeassignment.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.composeassignment.ui.theme.white
import com.example.composeassignment.viewmodel.ItemDetailVM


@Composable
fun ItemDetailScreen() {

    val viewModel : ItemDetailVM = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Item Detail",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                style = TextStyle(
                    fontWeight = FontWeight.W800,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text(
                    text = "Name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    maxLines = 1,
                    style = TextStyle(
                        fontWeight = FontWeight.W800,
                        fontSize = 25.sp
                    )
                )

                Text(text = (viewModel.item.name),
                    style = TextStyle(
                        fontSize = 25.sp
                    ))
            }


            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text(
                    text = "Price",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    maxLines = 1,
                    style = TextStyle(
                        fontWeight = FontWeight.W800,
                        fontSize = 25.sp
                    )
                )

                Text(text = (viewModel.item.price.toString()),
                    style = TextStyle(
                        fontSize = 25.sp
                    ))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                Text(
                    text = "Description",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f),
                    style = TextStyle(
                        fontWeight = FontWeight.W800,
                        fontSize = 25.sp
                    )
                )

                Text(
                    modifier = Modifier.
                    weight(0.5f),
                    text = (viewModel.item.description),
                    style = TextStyle(
                        fontSize = 25.sp
                    ))
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun show() {
    ItemDetailScreen()
}