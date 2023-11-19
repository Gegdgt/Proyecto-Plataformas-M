package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ProfilePostImage(image:String, modifier: Modifier = Modifier){
    Box(modifier = modifier){
        AsyncImage(model = image, contentDescription = "Post Perfil")
    }
}