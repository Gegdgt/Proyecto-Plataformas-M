package com.example.proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
<<<<<<< HEAD
import com.example.proyecto.profile_perfil.ProfileScreen
=======
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyecto.main_feed_screen.MainFeedScreen
import com.example.proyecto.navigation.AppNavigation
>>>>>>> Authentication
import com.example.proyecto.ui.theme.ProyectoTheme
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics

class MainActivity : ComponentActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoTheme {
<<<<<<< HEAD
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ProfileScreen()
                }
=======
                AppNavigation()
>>>>>>> Authentication
            }
        }
        //Analytics events
        firebaseAnalytics = Firebase.analytics
        bundle.putString("message", "Integracion de Firebase completa")
        firebaseAnalytics.logEvent("InitScreen", bundle)
    }
}
