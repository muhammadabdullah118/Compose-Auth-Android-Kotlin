package com.example.composeassignment.views.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composeassignment.model.Item
import com.example.composeassignment.utils.itemList
import com.example.composeassignment.views.components.ItemView

@Composable
fun DashBoardScreen(
    onItemDetail : (Item)->Unit
){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(

        ){
            items(
                itemList
            ){
                ItemView(
                    name = it.name ,
                    price = it.price,
                    onClick ={onItemDetail(it)}
                )
            }
        }
    }
}