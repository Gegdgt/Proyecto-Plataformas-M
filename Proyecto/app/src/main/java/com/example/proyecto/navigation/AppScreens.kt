package com.example.proyecto.navigation

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("HomeScreen")
    object SignUpScreen: AppScreens("SignUpScreen")
    object SignInScreen: AppScreens("SignInScreen")
    object MainFeedScreen: AppScreens("MainFeedScreen")
}