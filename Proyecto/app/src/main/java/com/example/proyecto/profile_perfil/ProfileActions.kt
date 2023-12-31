package com.example.proyecto.profile_perfil

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileActions(
    modifier: Modifier = Modifier
){
    Row(modifier = modifier.fillMaxWidth()){
        ProfileButton(onClick = { /*TODO*/ }, text = "Editar perfil", modifier = Modifier.weight(1f))
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