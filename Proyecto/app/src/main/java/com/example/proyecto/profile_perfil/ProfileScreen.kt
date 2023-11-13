package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.proyecto.R

@Composable
fun ProfileScreen() {
    Column {
        TopBar(
            backClick = {/*TODO*/},
            optionClick = {/*TODO*/}
        )
        ProfileInformation()
        ProfileDescription()
        BottomBar()
    }
}
@Composable
fun BottomBar(){
    BottomAppBar{
        NavigationBarItem(
            selected = false,
            onClick = {/*TODO*/},
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
            onClick = {/*TODO*/},
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
            onClick = {/*TODO*/},
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
fun TopBar(
    // Esto es lo que se debe poner en los onclicks
    // para moverse a otras pantallas
    backClick: () -> Unit,
    optionClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Flecha de regreso")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "@Perfil")
        Box {
            Row{
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Opciones")

                }
            }
        }
    }
}

@Composable
fun ProfileInformation(
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically ,horizontalArrangement = Arrangement.SpaceAround){
        // aqui hay que conectarlo con la base de datos y extraer todos estos datos
        AsyncImage(
            model = "https://via.placeholder.com/200",
            contentDescription = "Imagen de perfil",
            modifier = Modifier.clip(CircleShape)
        )
        ProfileInformationItem(0, "Publicaciones")
        ProfileInformationItem(300, "Seguidores")
        ProfileInformationItem(300, "Seguidos")
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
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier.fillMaxWidth()){
        Text(text = "Hola este es mi perfil", fontWeight = FontWeight.Bold)
        Text(text = "Descripción")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}