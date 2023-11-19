package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

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