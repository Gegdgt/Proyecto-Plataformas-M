package com.example.proyecto.main_feed_screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.proyecto.model.Posts
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(navController: NavController) {
    // Estado para almacenar la lista de publicaciones
    var posts by remember { mutableStateOf(emptyList<Posts>()) }

    // Instancia de Firestore
    val db = Firebase.firestore

    // Función para cargar la imagen utilizando Coil de manera asíncrona
    @Composable
    fun LoadImageFromStorage(imageUrl: String) {
        val imageReference = Firebase.storage.getReferenceFromUrl(imageUrl).toString()

        // Muestra un contenedor con una imagen de carga mientras se carga la imagen principal
        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
        ) {
            // Imagen de carga (placeholder)
            var isLoading by remember { mutableStateOf(true) }
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(48.dp)
                        .align(Alignment.Center)
                )
            }

            // Imagen principal cargada con Coil
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageReference).apply(block = fun ImageRequest.Builder.() {
                    crossfade(true)
                }).build()
            )

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // Ajusta según tus necesidades
            )

            // Observa el ciclo de vida para detectar cuándo la imagen se ha cargado
            DisposableEffect(painter) {
                // Se ejecutará cuando la imagen se haya cargado
                onDispose {
                    // Cambia el estado cuando la imagen se ha cargado
                    isLoading = false
                }
            }
        }
    }

    // Consulta la colección "posts" en Firestore
    LaunchedEffect(Unit) {
        db.collection("posts")
            .limit(10) // Limita la cantidad inicial de publicaciones
            .get()
            .addOnSuccessListener { result ->
                // Procesa los resultados exitosos de la consulta
                val postsList = result.toObjects(Posts::class.java)
                posts = postsList
            }
            .addOnFailureListener { exception ->
                // Maneja la falla en la consulta mostrando un mensaje de error
                Log.e("Firebase", "Error al obtener imágenes: $exception")
                // También podrías mostrar un mensaje en la UI para informar al usuario
            }
    }

    // Resto del código
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        bottomBar = {
            BottomBar(navController)
        },
        containerColor = Color.White,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            item { Divider() }
            items(posts) { post ->
                // Utiliza Coil para cargar la imagen desde Firebase Storage de manera asíncrona
                LoadImageFromStorage(post.imageUrl)

                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}



