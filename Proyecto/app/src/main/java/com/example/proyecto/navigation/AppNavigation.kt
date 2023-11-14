package com.example.proyecto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.Authentication.HomeScreen
import com.example.proyecto.Authentication.SignInScreen
import com.example.proyecto.Authentication.SignUpScreen
import com.example.proyecto.main_feed_screen.MainFeedScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.HomeScreen.route ){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(route = AppScreens.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = AppScreens.MainFeedScreen.route){
            MainFeedScreen(navController)
        }
    }

}