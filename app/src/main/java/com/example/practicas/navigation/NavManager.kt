package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicas.components.divisionComponent
import com.example.practicas.view.DivisionesView
import com.example.practicas.view.SplashScreen
import com.example.practicas.view.HomeView
import com.example.practicas.view.TeamOnBoarding

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "Splash"){
        composable("Home"){
            HomeView(navController)
        }
        composable ("Division/{id}", arguments =
        listOf(navArgument("id")
        {type = NavType.IntType})) {
            val id = it.arguments?.getInt("id")?:0
            DivisionesView(navController, id)
        }
        composable ("Splash"){
            SplashScreen(navController)
        }
        composable ("OnBoarding/{id}/{start}", arguments = listOf(navArgument("id"){type = NavType.IntType}, navArgument("start"){
            type = NavType.IntType
        })) {
            val id = it.arguments?.getInt("id")?:0
            val start = it.arguments?.getInt("start")?:0
            TeamOnBoarding(navController, id, start)
        }
    }
}