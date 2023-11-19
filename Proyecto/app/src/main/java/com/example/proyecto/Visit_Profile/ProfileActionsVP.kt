package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileActionsVP(
    modifier: Modifier = Modifier
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