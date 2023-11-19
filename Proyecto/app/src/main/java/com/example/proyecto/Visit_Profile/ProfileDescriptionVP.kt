package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProfileDescriptionVP(
    name: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column (modifier = modifier.fillMaxWidth()){
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = description)
    }
}