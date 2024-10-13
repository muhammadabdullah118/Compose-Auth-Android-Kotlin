package com.example.composeassignment.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.composeassignment.model.Item
import com.example.composeassignment.navigation.DestinationArgs
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.URLDecoder
import javax.inject.Inject

@HiltViewModel
class ItemDetailVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){

    val item : Item = Gson().fromJson(
        URLDecoder.decode(savedStateHandle[DestinationArgs.item], "UTF-8"),Item::class.java
    )

    init {
        Log.d("MyData" , "${item}")
    }
}