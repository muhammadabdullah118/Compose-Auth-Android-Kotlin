package com.example.composeassignment.viewmodel

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpVM @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val firstName = mutableStateOf("")
    val lastName = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    var gender = mutableStateOf("Options")

    fun setFirstName(data: String){
        firstName.value = data
    }

    fun setLastName(data: String){
        lastName.value = data
    }

    fun setEmail(data : String){
        email.value = data
    }

    fun setPassword(data : String){
        password.value = data
    }

    fun setConfirmPassword(data: String){
        confirmPassword.value = data
    }

    fun setGender(data: String){
        gender.value = data
    }

    fun isValidEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    fun isPasswordValid(pass: String, confirmPass: String): Boolean {
        return (password.value.length >= 8) &&
                (password.value == confirmPassword.value)
    }

    fun checkInput(): Boolean {
        return firstName.value.isNotEmpty()
                && lastName.value.isNotEmpty()
                && isValidEmail(email.value)
                && isPasswordValid(password.value, confirmPassword.value)
    }
}