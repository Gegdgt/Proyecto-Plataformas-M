package com.example.proyecto.navigation

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("HomeScreen")
    object SignInScreen: AppScreens("SignInScreen")
    object MainFeedScreen: AppScreens("MainFeedScreen")
    object ProfileScreen: AppScreens("ProfileScreen")
    object VisitProfile: AppScreens("VisitProfile")
    object SearchScreen: AppScreens("SearchScreen")
}
