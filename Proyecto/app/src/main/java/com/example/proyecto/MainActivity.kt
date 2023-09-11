package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto.main_feed_screen.MainFeedScreen
import com.example.proyecto.ui.theme.ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTheme {
                //No esta llamando a la funcion bien y no se porque
                MainFeedScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainActivityPreview() {
    MainActivity()
}
