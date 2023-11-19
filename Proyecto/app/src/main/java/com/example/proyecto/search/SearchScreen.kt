package com.example.proyecto.search


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.profile_perfil.ProfilePostImage

val allUsers = listOf(
    ExtraPost(
        users = "Mi usuario",
        posts = listOf(
            // Hay que usar imagenes que sean mayores a 360px, ese es el minimo
            // , Si son mas grandes mejor, porque los adapta Compose
            "https://via.placeholder.com/360",
            "https://via.placeholder.com/360",
            "https://via.placeholder.com/360",
            "https://via.placeholder.com/360",
            "https://via.placeholder.com/360",
            "https://via.placeholder.com/360"
        )
    ),
    ExtraPost(
        users = "Usuario1",
        posts = listOf(
            // Hay que usar imagenes que sean mayores a 360px, ese es el minimo
            // , Si son mas grandes mejor, porque los adapta Compose
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500",
            "https://via.placeholder.com/500"
        )
    ),
    ExtraPost(
        users = "Usuario2",
        posts = listOf(
            // Hay que usar imagenes que sean mayores a 360px, ese es el minimo
            // , Si son mas grandes mejor, porque los adapta Compose
            "https://via.placeholder.com/600",
            "https://via.placeholder.com/600",
            "https://via.placeholder.com/600",
            "https://via.placeholder.com/600",
            "https://via.placeholder.com/600",
            "https://via.placeholder.com/600"
        )
    ),
    ExtraPost(
        users = "Usuario3",
        posts = listOf(
            // Hay que usar imagenes que sean mayores a 360px, ese es el minimo
            // , Si son mas grandes mejor, porque los adapta Compose
            "https://via.placeholder.com/700",
            "https://via.placeholder.com/700",
            "https://via.placeholder.com/700",
            "https://via.placeholder.com/700",
            "https://via.placeholder.com/700",
            "https://via.placeholder.com/700"
        )
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {

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
            for (userPost in allUsers) {
                // Iterar sobre las imágenes de cada usuario
                for (postImage in userPost.posts) {
                    item {
                        ProfilePostImage(
                            image = postImage,
                            modifier = Modifier.padding(1.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(rememberNavController())
}