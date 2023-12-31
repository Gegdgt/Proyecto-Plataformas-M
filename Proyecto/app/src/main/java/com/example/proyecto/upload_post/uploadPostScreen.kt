package com.example.proyecto.upload_post

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyecto.Authentication.SignInScreenViewModel
import com.example.proyecto.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun uploadPostScreen(navController: NavController, signInViewModel: SignInScreenViewModel) {
    // Obtener el ViewModel
    val viewModel: SignInScreenViewModel = viewModel()

    // Obtener el userId del ViewModel
    val userId = signInViewModel.getCurrentUserId() ?: ""
    val displayName = signInViewModel.getCurrentDisplayname() ?: ""

    Box {
        Image(
            painter = painterResource(id = R.drawable.imagenfondo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
        )
        val isUploading = remember {
            mutableStateOf(false)
        }
        val context = LocalContext.current
        val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
        val bitmap = remember { mutableStateOf(img) }
        var commentText by remember { mutableStateOf("") }
        var ubicationText by remember { mutableStateOf("") }
        var likes by remember { mutableStateOf(0) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview()
        ) {
            if (it != null) {
                bitmap.value = it
            }
        }

        val launchImage = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = it?.let { it1 ->
                    ImageDecoder.createSource(context.contentResolver, it1)
                }
                bitmap.value = source?.let { it1 ->
                    ImageDecoder.decodeBitmap(it1)
                }!!
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 16.dp) // Modificado para dejar espacio en la parte inferior
        ) {
            Image(
                bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp)) // Puedes ajustar el radio según tus preferencias
                    .size(250.dp)
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            TextField(
                value = commentText,
                onValueChange = { commentText = it },
                label = { Text("Descripción...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            TextField(
                value = ubicationText,
                onValueChange = { ubicationText = it },
                label = { Text("Ubicación...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.padding(30.dp))
        }

        var showDialog by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .padding(top = 280.dp, start = 260.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(50.dp)
                    .padding(10.dp)
                    .clickable { showDialog = true }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
        ) {
            if (showDialog) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .width(300.dp)
                        .height(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray)
                ) {
                    Column(modifier = Modifier.padding(start = 60.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    launcher.launch()
                                    showDialog = false
                                }
                        )
                        Text(text = "Camara", color = Color.White)
                    }
                    Spacer(modifier = Modifier.padding(30.dp))
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = null,
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {
                                    launchImage.launch("image/*")
                                    showDialog = false
                                }
                        )
                        Text(text = "Galeria", color = Color.White)
                    }
                    Column(
                        modifier = Modifier
                            .padding(start = 80.dp, bottom = 80.dp)
                    ) {
                        Text(text = "X", color = Color.White, modifier = Modifier.clickable { showDialog = false })
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .height(450.dp)
                        .fillMaxWidth()
                ) {
                    if (isUploading.value) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(16.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
        ) {
            Button(
                onClick = {
                    isUploading.value = true
                    bitmap.value.let { bitmap ->
                        uploadImageToFirebase(
                            bitmap,
                            context as ComponentActivity,
                            userId,
                            displayName,
                            commentText,
                            ubicationText,
                            likes
                        ) { success ->
                            isUploading.value = false
                            if (success) {
                                Toast.makeText(context, "Subida exitosa", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Error al subir", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color.Gray
                )
            ) {
                Text(
                    text = "Añadir al perfil",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

fun uploadImageToFirebase(
    bitmap: Bitmap,
    context: ComponentActivity,
    userId: String,
    displayName: String,
    commentText: String,
    ubicationText: String,
    likes: Int,
    callback: (Boolean) -> Unit
) {
    val storageRef = Firebase.storage.reference
    val userImagesRef =
        storageRef.child("images/$userId/") // Aquí se utiliza el userId para crear la ruta

    val imageName = "${UUID.randomUUID()}.jpg" // Nombre único para la imagen

    val imageRef = userImagesRef.child(imageName)

    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val imageData = baos.toByteArray()
    // Subir la imagen a Firebase Storage
    imageRef.putBytes(imageData)
        .addOnSuccessListener { _ ->
            imageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                val imageUrl = downloadUrl.toString()

                // Guardar la información de la imagen en Firestore
                saveImageInfoToFirestore(
                    userId,
                    imageName,
                    imageUrl,
                    displayName,
                    commentText,
                    ubicationText,
                    likes
                ) { success ->
                    if (success) {
                        callback(true)
                    } else {
                        callback(false)
                    }
                }
            }.addOnFailureListener {
                callback(false)
            }
        }
        .addOnFailureListener {
            callback(false)
        }
}

private fun saveImageInfoToFirestore(
    userId: String,
    imageName: String,
    imageUrl: String,
    displayName: String,
    commentText: String,
    ubicationText: String,
    likes: Int,
    callback: (Boolean) -> Unit
) {
    // Aquí puedes guardar la información de la imagen en Firestore
    val firestore = Firebase.firestore

    // Referencia a la colección "images"
    val imagesCollectionRef = firestore.collection("images")

    // Crear un documento con información de la imagen
    val imageInfo = hashMapOf(
        "user_Id" to userId,
        "imageName" to imageName,
        "imageUrl" to imageUrl,
        "description" to commentText,
        "location" to ubicationText,
        "likes" to likes

        // Agregar otros campos relacionados con la imagen si es necesario
    )

    // Agregar el documento a la colección "images"
    imagesCollectionRef.add(imageInfo)
        .addOnSuccessListener {
            // La información de la imagen se guardó correctamente en Firestore
            callback(true)
        }
        .addOnFailureListener {
            // Manejar el error al guardar la información de la imagen en Firestore
            callback(false)
        }
}

@Preview
@Composable
fun uploadPostScreenPreview(){
    uploadPostScreen(rememberNavController(), viewModel())
}