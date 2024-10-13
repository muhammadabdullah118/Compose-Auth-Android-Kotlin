package com.example.composeassignment.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments =
        navArguments.filter { it.argument.defaultValue == null }.takeIf { it.isNotEmpty() } ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }.orEmpty()
    val optionalArguments =
        navArguments.filter { it.argument.defaultValue != null }.takeIf { it.isNotEmpty() } ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }.orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

sealed class ComposeAssignmentScreens(
    val route : String ,
    val navArguments: List<NamedNavArgument> = emptyList()
){
    val name = route.appendArguments(navArguments)

    object SignUpScreen : ComposeAssignmentScreens(route = "SignUp")

    object DashBoardScreen : ComposeAssignmentScreens(route = "DashBoardScreen")

    object ItemDetailScreen : ComposeAssignmentScreens(
        route = "ItemDetail",
        navArguments = listOf(
            navArgument(DestinationArgs.item){
                type = NavType.StringType
            }
        )
    )
}
