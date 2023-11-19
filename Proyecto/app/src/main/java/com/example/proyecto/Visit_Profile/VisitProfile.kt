package com.example.proyecto.Visit_Profile

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
fun VisitProfile(navController: NavController) {
    val VisitUser = VisitUser(
        vUsername = "Perfil_Visita123",
        vProfileImagen = "https://via.placeholder.com/200",
        vPostCount = 15,
        vFollowers = 388,
        vFollowing = 360,
        vName = "Nombre Generico",
        vDescription = "Este es mi descripcion",
        vPosts = listOf(
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
            TopBarVS(
                backClick = {/*TODO*/ },
                optionClick = {/*TODO*/ },
                username = VisitUser.vUsername
            )
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
                ProfileInformationVP(
                    imagen = VisitUser.vProfileImagen,
                    posts = VisitUser.vPostCount,
                    followers = VisitUser.vFollowers,
                    following = VisitUser.vFollowing
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileDescriptionVP(
                    name = VisitUser.vName,
                    description = VisitUser.vDescription,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileActionsVP(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            items(VisitUser.vPosts) {
                ProfilePostImageVP(
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
    VisitProfile(rememberNavController())
}