package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicas.view.SplashScreen
import com.example.practicas.view.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "Splash"){
        composable("Home"){
            HomeView(navController)
        }
        composable ("Splash"){
            SplashScreen(navController)
        }
    }
}