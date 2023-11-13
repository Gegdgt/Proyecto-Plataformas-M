package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyecto.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold (
    topBar = {
        com.example.proyecto.main_feed_screen.TopBar()
    },
    bottomBar = {
        com.example.proyecto.main_feed_screen.BottomBar()
    },
    containerColor = Color.White,

    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ){
            item{ Divider() }
        }
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
    // backClick: () -> Unit,
    // notificationClick: () -> Unit,
    // optionClick: () -> Unit
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
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notificaciones")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Opciones")

                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    TopBar()
}