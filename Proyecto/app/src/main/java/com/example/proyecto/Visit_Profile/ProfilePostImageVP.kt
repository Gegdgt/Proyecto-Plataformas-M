package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ProfilePostImageVP(image:String, modifier: Modifier = Modifier){
    Box(modifier = modifier){
        AsyncImage(model = image, contentDescription = "Post Perfil")

    }
}