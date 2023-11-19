package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.navigation.AppScreens

@Composable
fun BottomBarPS(navController: NavController){
    BottomAppBar{
        NavigationBarItem(
            selected = false,
            onClick = {navController.navigate(route = AppScreens.MainFeedScreen.route)},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = "Home Screen",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {navController.navigate(route = AppScreens.SearchScreen.route)},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = "Search Screen",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
        NavigationBarItem(
            selected = true,
            onClick = {navController.navigate(route = AppScreens.ProfileScreen.route)},
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_person_24),
                    contentDescription = "Profile",
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp)
                )
            }
        )
    }
}