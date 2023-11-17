package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage

@Composable
fun ProfileInformationVP(
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