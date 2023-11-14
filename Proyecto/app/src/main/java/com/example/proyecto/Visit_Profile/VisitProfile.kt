package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells.Fixed
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage


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
            TopBarPS(
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
                ProfileInformation(
                    imagen = VisitUser.vProfileImagen,
                    posts = VisitUser.vPostCount,
                    followers = VisitUser.vFollowers,
                    following = VisitUser.vFollowing
                )
            }
            item(span = {
                GridItemSpan(size)
            }) {
                ProfileDescription(
                    name = VisitUser.vName,
                    description = VisitUser.vDescription,
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
            items(VisitUser.vPosts) {
                ProfilePostImage(
                    image = it,
                    modifier = Modifier.padding(1.dp)
                )
            }
        }
    }
}

@Composable
fun ProfilePostImage(image:String, modifier: Modifier = Modifier){
    Box(modifier = modifier){
        AsyncImage(model = image, contentDescription = "Post Perfil")

    }
}
@Composable
fun TopBarPS(
    // Esto es lo que se debe poner en los onclicks
    // para moverse a otras pantallas
    backClick: () -> Unit,
    optionClick: () -> Unit,
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = { backClick }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Flecha de regreso")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = username)
        Box {
            Row{
                IconButton(onClick = { optionClick }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Opciones")
                }
            }
        }
    }
}

@Composable
fun ProfileInformation(
    imagen : String,
    posts: Int,
    followers: Int,
    following: Int,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically ,horizontalArrangement = Arrangement.SpaceAround){
        // aqui hay que conectarlo con la base de datos y extraer todos estos datos
        AsyncImage(
            model = imagen,
            contentDescription = "Imagen de perfil",
            modifier = Modifier.clip(CircleShape)
        )
        ProfileInformationItem(posts, "Publicaciones")
        ProfileInformationItem(followers, "Seguidores")
        ProfileInformationItem(following, "Seguidos")
    }
}
@Composable
fun ProfileInformationItem(
    amount: Int,
    type: String,
    modifier: Modifier = Modifier
){
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = amount.toString(), fontWeight = FontWeight.Bold)
        Text(text = type)
    }
}

@Composable
fun ProfileDescription(
    name: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier.fillMaxWidth()){
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = description)
    }
}
@Composable
fun ProfileActions(
    modifier: Modifier= Modifier
){
    Row(modifier = modifier.fillMaxWidth()){
        ProfileButton(onClick = { /*TODO*/ }, text = "Seguir", modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        ProfileButton(onClick = { /*TODO*/ }, text = "Mensaje", modifier = Modifier.weight(1f))
    }
}

@Composable
private fun ProfileButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    VisitProfile(rememberNavController())
}