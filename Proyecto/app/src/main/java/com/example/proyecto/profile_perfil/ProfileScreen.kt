package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val user = User(
        username = "Profile_Prueba123",
        profileImagen = "https://via.placeholder.com/200",
        postCount = 15,
        followers = 388,
        following = 360,
        name = "Nombre Generico",
        description = "Este es mi descripcion",
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
    Scaffold (
        topBar = {
            TopBarPS(
                optionClick = {/*TODO*/ },
                username = user.username
            )
        },
        bottomBar = {
            BottomBarPS(navController)
        },
        ) {innerPadding ->
        val size = 3
        LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = Fixed(size)
        ) {
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileInformation(
                    imagen = user.profileImagen,
                    posts = user.postCount,
                    followers = user.followers,
                    following = user.following
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileDescription(
                    name = user.name,
                    description = user.description,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileActions(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            items(user.posts) {
                ProfilePostImage(
                    image = it,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}