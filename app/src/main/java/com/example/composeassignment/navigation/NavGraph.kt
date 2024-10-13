package com.example.composeassignment.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.composeassignment.utils.App_Nav_Graph
import com.example.composeassignment.views.screens.DashBoardScreen
import com.example.composeassignment.views.screens.ItemDetailScreen
import com.example.composeassignment.views.screens.SignUpForm
import com.google.gson.Gson
import java.net.URLEncoder

fun NavGraphBuilder.appNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = ComposeAssignmentScreens.SignUpScreen.name,
        route = App_Nav_Graph
    ) {
        composable(
            route = ComposeAssignmentScreens.SignUpScreen.name
        ) {
            SignUpForm(
                onDashBoard = {
                    navController.navigate(ComposeAssignmentScreens.DashBoardScreen.name)
                }
            )
        }
        composable(
            route = ComposeAssignmentScreens.DashBoardScreen.name
        ) {
            DashBoardScreen(
                onItemDetail = { item ->
                    val data = Gson().toJson(item)
                    navController.navigate(ComposeAssignmentScreens.ItemDetailScreen.route + "/ ${URLEncoder.encode(data, "UTF-8")}")
                }
            )
        }
        composable(
            route = ComposeAssignmentScreens.ItemDetailScreen.name
        ) {
            ItemDetailScreen()
        }
    }

}

// *********/ BASIC NAVIGATION / *******************

//composable(
//route = "SignUp"
//){
//    SignUpForm(
//        onDashBoard ={
//            navController.navigate("DashBoardScreen")
//        }
//    )
//}
//composable(
//route="DashBoardScreen"
//) {
//    DashBoardScreen(
//        onItemDetail = {
//                item ->
//            val data = Gson().toJson(item)
//            navController.navigate("ItemDetail" + "/ ${URLEncoder.encode(data , "UTF-8")}")
//        }
//    )
//}
//composable(
//route = "ItemDetail/{item}",
//arguments = listOf(
//navArgument("item"){
//    type = NavType.StringType
//}
//)
//){
//    ItemDetailScreen()
//}