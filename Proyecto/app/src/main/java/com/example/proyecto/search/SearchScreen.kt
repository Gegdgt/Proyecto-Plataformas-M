package com.example.proyecto.search


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.R
import com.example.proyecto.navigation.AppScreens
import com.example.proyecto.profile_perfil.ProfilePostImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    val extraPost = ExtraPost(
        users = listOf(
            "Usuario1",
            "Usuario2",
            "Usuario3",
            "Usuario4",
            "Usuario5",
            "Usuario6",
            "Usuario7",
            "Usuario8",
            "Usuario9",
            "Usuario10",
            "Usuario11",
            "Usuario12"

            ),
        posts = listOf(
            // Hay que usar imagenes que sean mayores a 360px, ese es el minimo
            // , Si son mas grandes mejor, porque los adapta Compose
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500"
        )
    )
        Scaffold(
            topBar = {
                TopBarSS()
            },
            bottomBar = {
                BottomBarSS(navController)
            },
            containerColor = Color.White,

            ) {innerPadding ->
            val size = 3
            LazyVerticalGrid(
                modifier = Modifier.padding(innerPadding),
                columns = GridCells.Fixed(size)
            ) {
                items(extraPost.posts) {
                    ProfilePostImage(
                        image = it,
                        modifier = Modifier.padding(1.dp)
                    )
                }
            }
        }

}

@Composable
fun BottomBarSS(navController: NavController){
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
            selected = true,
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
            selected = false,
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
@Composable
fun TopBarSS() {

}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(rememberNavController())
}