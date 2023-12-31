package com.example.proyecto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.Authentication.BreakSplashScreen
import com.example.proyecto.Authentication.SignInScreen
import com.example.proyecto.Authentication.SignInScreenViewModel
import com.example.proyecto.Visit_Profile.VisitProfile
import com.example.proyecto.main_feed_screen.MainFeedScreen
import com.example.proyecto.profile_perfil.ProfileScreen
import com.example.proyecto.search.SearchScreen
import com.example.proyecto.upload_post.uploadPostScreen

@Composable
fun AppNavigation(){


    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = AppScreens.SplashScreen.route ){
        composable(route = AppScreens.SplashScreen.route){
            BreakSplashScreen(navController = navController, coroutineScope = rememberCoroutineScope())

        }
        composable(route = AppScreens.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(route = AppScreens.MainFeedScreen.route){
            MainFeedScreen(navController)
        }
        composable(route = AppScreens.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(route = AppScreens.VisitProfile.route){
            VisitProfile(navController)
        }
        composable(route = AppScreens.SearchScreen.route){
            SearchScreen(navController)
        }
        composable(route = AppScreens.UploadPostScreen.route){
            val signInViewModel: SignInScreenViewModel = viewModel()
            uploadPostScreen(navController,signInViewModel)
        }
    }

}