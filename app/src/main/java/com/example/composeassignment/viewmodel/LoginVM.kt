package com.example.composeassignment.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginVM  @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val email = mutableStateOf("")
    val password = mutableStateOf("")

}