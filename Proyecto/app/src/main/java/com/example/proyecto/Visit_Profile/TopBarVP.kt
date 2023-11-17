package com.example.proyecto.Visit_Profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBarVS(
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
